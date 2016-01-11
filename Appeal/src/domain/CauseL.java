package domain;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class CauseL implements Comparable<CauseL> {
	
	private Integer id;
	private String name;
	private TypeL type;
	private Set<Rectif1L> rectifs1 = new TreeSet<Rectif1L>();

	public CauseL(String name, int id) {
		this.name = name;
		this.type = new TypeL("aa", 1);
		this.id = id;
	}
	
	public CauseL addRectif1(String name, int id) {
		Rectif1L rectif1 = new Rectif1L(name, id);
		this.rectifs1.add(rectif1);
		return this;
	}

	public int compareTo(CauseL o) {
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
		CauseL other = (CauseL) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
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

	public TypeL getType() {
		return this.type;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(TypeL type) {
		this.type = type;
	}
	
	public Set<Rectif1L> getRectifs1() {
		return Collections.unmodifiableSet(this.rectifs1);
	}

	public Rectif1L getRectif1(int id) {
		Rectif1L result = null;
		for (Rectif1L c : this.rectifs1) {
			if (c.getId() == id) {
				return c;
			}
		}
		return result;
	}
	
	public void setRectifs1(Set<Rectif1L> rectifs1) {
		this.rectifs1 = rectifs1;
	}

}
