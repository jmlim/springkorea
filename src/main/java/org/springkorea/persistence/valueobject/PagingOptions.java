package org.springkorea.persistence.valueobject;

public class PagingOptions {
	private int offset = 0;

	private int size;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
