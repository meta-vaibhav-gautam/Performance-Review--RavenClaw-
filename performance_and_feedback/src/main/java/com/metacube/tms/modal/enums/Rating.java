package com.metacube.tms.modal.enums;

public enum Rating {
	ALWAYS("Always / Strongly Agree", 100), OFTEN("Often / Agree", 75), SOMETIME("Sometime / SomeWhat Agree",
			50), RARELY("Rarely / Disagree", 25), NEVER("Never / Strongly Disagree", 0);

	private String label;
	private int value;

	Rating(String label, int value) {
		this.setLabel(label);
		this.setValue(value);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
