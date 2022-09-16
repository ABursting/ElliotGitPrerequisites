import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TreeTester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("blob : f572d396fae9206628714fb2ce00f72e94f2258f");
		list.add("tree : a3c08f49f4ca57e65a979f705bdc1400b6f8ab61");
		list.add("tree : 414056cd01c25746bd538ec20505f5407f0d5605");
		Tree tree = new Tree(list);
		System.out.println("bro hash: " + tree.encrypt("bro"));
		tree.createIndexFile();
	}

}
