package domain;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Rectif1L implements Comparable<Rectif1L> {
	
	private Integer id;
	private String name;
	private CauseL cause;
	private Set<Rectif2L> rectifs2 = new TreeSet<Rectif2L>();

	public Rectif1L(String name, int id) {
		this.name = name;
		this.cause = new CauseL("aa", 1);
		this.id = id;
	}
	
	public Rectif1L addRectif2(String name, int id) {
		Rectif2L rectif2 = new Rectif2L(name, id);
		this.rectifs2.add(rectif2);
		return this;
	}

	public int compareTo(Rectif1L o) {
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
		Rectif1L other = (Rectif1L) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.cause == null) {
			if (other.cause != null) {
				return false;
			}
		} else if (!this.cause.equals(other.cause)) {
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

	public CauseL getCause() {
		return this.cause;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCause(CauseL cause) {
		this.cause = cause;
	}
	
	public Set<Rectif2L> getRectifs2() {
		return Collections.unmodifiableSet(this.rectifs2);
	}

	public Rectif2L getRectif2(int id) {
		Rectif2L result = null;
		for (Rectif2L c : this.rectifs2) {
			if (c.getId() == id) {
				return c;
			}
		}
		return result;
	}
	
	public void setRectifs2(Set<Rectif2L> rectifs2) {
		this.rectifs2 = rectifs2;
	}

}
