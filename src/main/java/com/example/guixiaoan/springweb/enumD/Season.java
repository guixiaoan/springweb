package com.example.guixiaoan.springweb.enumD;


public enum Season {
	spring("spring11", "绿色", "春天") ,
	summer("summer", "绿色+", "夏天") ,
	autumn("autumn", "黄色", "秋天") ,
	winter("winter", "白色", "冬天") ;

	private final String name ;
	private final String color ;
	private final String desc ;

	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public String getDesc() {
		return desc;
	}

	private Season(String name , String color, String desc) {
		this.name = name ;
		this.color = color ;
		this.desc = desc ;
	}

	public String toString() {
		return this.getName()+this.getColor()+this.getDesc() ;
	}


}



