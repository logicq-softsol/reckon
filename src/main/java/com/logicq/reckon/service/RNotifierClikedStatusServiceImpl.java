package com.logicq.reckon.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.logicq.reckon.model.RNotifierClikedStatus;
import com.logicq.reckon.model.Threshold;
import com.logicq.reckon.repository.ClickedRnotifyDetailsRepository;
import com.logicq.reckon.threshold.ThresholdRepository;

@Service
public class RNotifierClikedStatusServiceImpl implements RNotifierClikedStatusService {

	@Autowired
	SimpMessagingTemplate brokerMessagingTemplate;

	@Autowired
	ClickedRnotifyDetailsRepository clickedRnotifyDetailsRepository;

	@Autowired
	ThresholdRepository thresholdRepository;

	@Autowired
	Environment env;

	@Scheduled(fixedRate = 30000)
	public void sendMessage() {
		Map<Long, RNotifierClikedStatus> rnotifyMaped = clikedNotifiersDetails().stream()
				.collect(Collectors.toMap(RNotifierClikedStatus::getLinkedId, Function.identity()));

		brokerMessagingTemplate.convertAndSend("/topics/event",
				JSON.toJSONString(rnotifyMaped, SerializerFeature.BrowserCompatible));
	}

	public List<RNotifierClikedStatus> clikedNotifiersDetails() {
		List<RNotifierClikedStatus> rnotifiers = clickedRnotifyDetailsRepository.findAll();
		if (!rnotifiers.isEmpty()) {
			List<Threshold> thresolds = thresholdRepository.findAllByOrderByIntervalDesc();
			rnotifiers.stream().forEach(noti -> {
				Date current = new Date();
				Date clickedDate = noti.getClickTime();
				long duration = current.getTime() - clickedDate.getTime();
				if (duration < 600000) {
					Optional<Threshold> thrOption = thresolds.stream()
							.filter(thr -> ((thr.getInterval() * 1000) <= duration)).findFirst();
					if (thrOption.isPresent()) {
						noti.setClickStatus(thrOption.get().getName());
						//String fetchedColorCode = thrOption.get().getColorCode().replaceFirst("#", "");
						String colorCode = env.getProperty(thrOption.get().getName());
						noti.setColorCode(colorCode);
						String iconURL = "assets/img/hotel/" + noti.getServiceName().toLowerCase() + "/"
								+ thrOption.get().getName().toLowerCase() + ".png";
						noti.setClickStatusIcon(iconURL);
					}
				} else {
					clickedRnotifyDetailsRepository.delete(noti);
				}
			});

		}
		return rnotifiers;
	}

}
