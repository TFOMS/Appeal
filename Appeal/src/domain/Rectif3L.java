package domain;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Rectif3L implements Comparable<Rectif3L> {
	
	private Integer id;
	private String name;
	private Rectif2L rectif2;
	private Set<Rectif4L> rectifs4 = new TreeSet<Rectif4L>();

	public Rectif3L(String name, int id) {
		this.name = name;
		this.rectif2 = new Rectif2L("aa", 1);
		this.id = id;
	}
	
	public Rectif3L addRectif4(String name, int id) {
		Rectif4L rectif4 = new Rectif4L(name, id);
		this.rectifs4.add(rectif4);
		return this;
	}

	public int compareTo(Rectif3L o) {
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
		Rectif3L other = (Rectif3L) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.rectif2 == null) {
			if (other.rectif2 != null) {
				return false;
			}
		} else if (!this.rectif2.equals(other.rectif2)) {
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

	public Rectif2L getRectif2() {
		return this.rectif2;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRectif2(Rectif2L rectif2) {
		this.rectif2 = rectif2;
	}
	
	public Set<Rectif4L> getRectifs4() {
		return Collections.unmodifiableSet(this.rectifs4);
	}

	public Rectif4L getRectif4(int id) {
		Rectif4L result = null;
		for (Rectif4L c : this.rectifs4) {
			if (c.getId() == id) {
				return c;
			}
		}
		return result;
	}
	
	public void setRectifs4(Set<Rectif4L> rectifs4) {
		this.rectifs4 = rectifs4;
	}

}
