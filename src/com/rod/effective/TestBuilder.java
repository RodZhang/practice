package com.rod.effective;

public class TestBuilder {
	private int id;

	private int age;

	private String name;

	private int sex;

	public TestBuilder(Builder builder) {
		id = builder.id;
		age = builder.age;
		name = builder.name;
		sex = builder.sex;
	}

	public static void main(String[] args) {
		TestBuilder test = new TestBuilder.Builder("rod").setAge(24).setId(1)
				.setSex(2).build();
		System.out.println("id: " + test.id + "\nname: " + test.name
				+ "\nage: " + test.age + "\nsex: "
				+ ((test.sex == 1) ? "Å®" : "ÄĞ"));
	}

	private static class Builder {
		private int id;

		private int age;

		private String name;

		private int sex;

		public Builder(String name) {
			this.name = name;
		}

		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Builder setSex(int sex) {
			this.sex = sex;
			return this;
		}

		public TestBuilder build() {
			return new TestBuilder(this);
		}
	}

}
