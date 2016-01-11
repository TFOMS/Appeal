package domain;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TypeL implements Comparable<TypeL> {
	
	private Integer id;
	private String name;
	private Set<CauseL> causes = new TreeSet<CauseL>();

	public TypeL(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public TypeL addCause(CauseL cause) {
		this.causes.add(cause);
		cause.setType(this);
		return this;
	}
	
	public TypeL addCause(String name, int id) {
		CauseL cause = new CauseL(name, id);
		this.causes.add(cause);
		return this;
	}

	public int compareTo(TypeL o) {
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
		TypeL other = (TypeL) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public Set<CauseL> getCauses() {
		return Collections.unmodifiableSet(this.causes);
	}

	public CauseL getCause(int id) {
		CauseL result = null;
		for (CauseL c : this.causes) {
			if (c.getId() == id) {
				return c;
			}
		}
		return result;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setCauses(Set<CauseL> causes) {
		this.causes = causes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}