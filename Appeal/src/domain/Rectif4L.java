package domain;

public class Rectif4L implements Comparable<Rectif4L> {
	
	private Integer id;
	private String name;
	private Rectif3L rectif3;

	public Rectif4L(String name, int id) {
		this.name = name;
		this.rectif3 = new Rectif3L("aa", 1);
		this.id = id;
	}

	public int compareTo(Rectif4L o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Rectif4L other = (Rectif4L) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.rectif3 == null) {
			if (other.rectif3 != null) {
				return false;
			}
		} else if (!this.rectif3.equals(other.rectif3)) {
			return false;
		}
		return true;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Rectif3L getRectif3() {
		return this.rectif3;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRectif3(Rectif3L rectif3) {
		this.rectif3 = rectif3;
	}

}
