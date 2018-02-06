package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ZipCodeApplication {
	
	public static void main(String[] args) {
		ArrayList<ZipCodeInterval> zipCodeIntervals = new ArrayList<>();
		
		//initial provided example
		zipCodeIntervals.add(new ZipCodeInterval(94133L, 94133L));
		zipCodeIntervals.add(new ZipCodeInterval(94200L, 94299L));
		zipCodeIntervals.add(new ZipCodeInterval(94600L, 94699L));
		
		System.out.println("-----First Example Input--------");
		zipCodeIntervals.stream().forEach(System.out::println);
		System.out.println();

		ArrayList<ZipCodeInterval> firstExample =  combineZipCodes(zipCodeIntervals);
		System.out.println("-----First Example Output--------");
		firstExample.stream().forEach(System.out::println);
		System.out.println();

		zipCodeIntervals.clear();
		
		//secondary example
		zipCodeIntervals.add(new ZipCodeInterval(94133L, 94133L));
		zipCodeIntervals.add(new ZipCodeInterval(94200L, 94299L));
		zipCodeIntervals.add(new ZipCodeInterval(94226L, 94399L));
		
		System.out.println("-----Second Example Input--------");
		zipCodeIntervals.stream().forEach(System.out::println);
		System.out.println();
		ArrayList<ZipCodeInterval> secondExample =  combineZipCodes(zipCodeIntervals);
		System.out.println("-----Second Example Output--------");
		secondExample.stream().forEach(System.out::println);
	}
	
	public static ArrayList<ZipCodeInterval> combineZipCodes(ArrayList<ZipCodeInterval> zipCodeIntervals) {
		Collections.sort(zipCodeIntervals, new CompareZipCodeIntervals());
		
		ArrayList<ZipCodeInterval> replaced = new ArrayList<>();
		
		Long inner = zipCodeIntervals.get(0).getInner();
		Long outer = zipCodeIntervals.get(0).getOuter();
		
		for(ZipCodeInterval zip: zipCodeIntervals) {
			if(zip.getInner() <= outer) {
				outer = Math.max(outer, zip.getOuter());
			} else {
				replaced.add(new ZipCodeInterval(inner,outer));
				inner = zip.getInner();
				outer = zip.getOuter();
			}
		}
		
		replaced.add(new ZipCodeInterval(inner, outer));
		return replaced;
	}
}
