package demo;

import java.util.Comparator;

public class CompareZipCodeIntervals implements Comparator<ZipCodeInterval> {
	@Override
	public int compare(ZipCodeInterval z1, ZipCodeInterval z2) {
		return Long.compare(z1.getInner(), z2.getInner());
	}
}
