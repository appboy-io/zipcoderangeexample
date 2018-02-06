package demo;

public class ZipCodeInterval {
	private Long inner;
	private Long outer;
	
	ZipCodeInterval(Long inner, Long outer) {
		this.inner = inner;
		this.outer = outer;
	}
	
	public Long getInner() {
		return inner;
	}
	
	public void setInner(Long inner) {
		this.inner = inner;
	}
	
	public Long getOuter() {
		return outer;
	}
	
	public void setOuter(Long outer) {
		this.outer = outer;
	}
	
	@Override
	public String toString() {
		return String.format("[%d,%d]", this.inner, this.outer);
	}
}
