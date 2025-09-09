package com.kh.example.gearrent;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Device {
	private String id;
	private String name;
	private String category;
	private int borrowCount;
	private Set<String> tags=new HashSet<>();;
	                                                                                                          
	
	public Device(String id, String name, String category, Set<String> tags) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.tags = tags;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBorrowCount() {
		return borrowCount;
	}

	public void setBorrowCount(int borrowCount) {
		this.borrowCount = borrowCount;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public abstract int getBorrowLimitDays();
	
	public abstract int calcLateFee(int overdueDays);
	
	public void increaseBorrowCount() {
        borrowCount++;
	}
	
	public boolean hasTag(String tag) {
		//대소문자 무시 비교(예: tag.toLowerCase() 사용)
		if (tag == null) return false;
        String lowerTag = tag.toLowerCase();
        for (String t : tags) {
            if (t.toLowerCase().equals(lowerTag)) {
                return true;
            }
        }
        return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (!(obj instanceof Device)) return false;
        Device device = (Device) obj;
        return Objects.equals(id, device.id);
	}

	@Override
	public String toString() {
		return "["+id+"] "+ name+" ("+category+") | 대여수="+borrowCount+" | tags=["+tags+","+tags+"]";
	}
}