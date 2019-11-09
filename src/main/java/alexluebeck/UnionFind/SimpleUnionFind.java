package alexluebeck.UnionFind;

import java.util.ArrayList;
import java.util.HashSet;

public class SimpleUnionFind implements UnionFind {
	private ArrayList<Integer> inWhichSet;
	private ArrayList<HashSet<Integer>> sets;
	private int numOfSets;

	public SimpleUnionFind(int size) {
		numOfSets = size;
		sets = new ArrayList<HashSet<Integer>>(size);
		inWhichSet = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			HashSet<Integer> tmpHashSet = new HashSet<Integer>();
			tmpHashSet.add(i);
			sets.add(tmpHashSet);
			inWhichSet.add(i);
		}
	}

	public int find(int i) {
		return inWhichSet.get(i);
	}

	public void union(int y, int z) {
		int size1 = sets.get(inWhichSet.get(y)).size();
		int size2 = sets.get(inWhichSet.get(z)).size();

		if (inWhichSet.get(y) != inWhichSet.get(z)) {
			numOfSets--;
		}

		if (size1 >= size2) {
			HashSet<Integer> source = sets.get(inWhichSet.get(z));
			HashSet<Integer> dest = sets.get(inWhichSet.get(y));
			for (Integer x : source) {
				dest.add(x);
				inWhichSet.set(x, inWhichSet.get(y));
			}
			source.clear();
		} else {
			HashSet<Integer> source = sets.get(inWhichSet.get(y));
			HashSet<Integer> dest = sets.get(inWhichSet.get(z));
			for (Integer x : source) {
				dest.add(x);
				inWhichSet.set(x, inWhichSet.get(z));
			}
			source.clear();
		}
	}

	public int getNumberOfNonEmptySets() {
		return this.numOfSets;
	}

}
