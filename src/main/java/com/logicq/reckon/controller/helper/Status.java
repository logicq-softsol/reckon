package com.logicq.reckon.controller.helper;

public enum Status {

	LINKED("LINKED"), NOT_LINKED("NOT_LINKED");

	
	 private final String text;

	    /**
	     * @param text
	     */
	    private Status(final String text) {
	        this.text = text;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
}
