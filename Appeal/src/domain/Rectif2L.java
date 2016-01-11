package domain;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Rectif2L implements Comparable<Rectif2L> {
	
	private Integer id;
	private String name;
	private Rectif1L rectif1;
	private Set<Rectif3L> rectifs3 = new TreeSet<Rectif3L>();

	public Rectif2L(String name, int id) {
		this.name = name;
		this.rectif1 = new Rectif1L("aa", 1);
		this.id = id;
	}
	
	public Rectif2L addRectif3(String name, int id) {
		Rectif3L rectif3 = new Rectif3L(name, id);
		this.rectifs3.add(rectif3);
		return this;
	}

	public int compareTo(Rectif2L o) {
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
		Rectif2L other = (Rectif2L) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.rectif1 == null) {
			if (other.rectif1 != null) {
				return false;
			}
		} else if (!this.rectif1.equals(other.rectif1)) {
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

	public Rectif1L getRectif1() {
		return this.rectif1;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRectif1(Rectif1L rectif1) {
		this.rectif1 = rectif1;
	}
	
	public Set<Rectif3L> getRectifs3() {
		return Collections.unmodifiableSet(this.rectifs3);
	}

	public Rectif3L getRectif3(int id) {
		Rectif3L result = null;
		for (Rectif3L c : this.rectifs3) {
			if (c.getId() == id) {
				return c;
			}
		}
		return result;
	}
	
	public void setRectifs3(Set<Rectif3L> rectifs3) {
		this.rectifs3 = rectifs3;
	}

}
