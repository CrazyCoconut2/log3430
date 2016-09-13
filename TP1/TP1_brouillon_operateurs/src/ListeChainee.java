/**
 * 
 */

/**
 * @author jennikhoury
 *
 */

import java.util.*;
public class ListeChainee {
	
	public ListeChainee(String operateur,ArrayList<Integer> val1,ArrayList<Integer> val2)
	{
		
	}
	
	public ListeChainee()
	{
		val1_ = new ArrayList<Integer>();
		val2_ = new ArrayList<Integer>();
		
		val1_.add(2);
		val1_.add(23);
		val1_.add(15);
		val1_.add(5);
		
		val2_.add(2);
		val2_.add(56);
		val2_.add(12);
		val2_.add(3);
		val2_.add(5);	
		
		size1_ = val1_.size();
		size2_ = val2_.size();
		
		operator_ = "union";

	}
	
	public void printResult(){
		System.out.println("Operator : " + operator_);
		System.out.println("Array 1 : " + val1_);
		System.out.println("Array 2 : " + val2_);
		System.out.println("Result : " + computeResult());
	}
	
	private ArrayList<Integer> computeResult(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (operator_.equals("union")){
			result = computeUnion();
		} else if (operator_.equals("union")){
			result = computeUnion();
		} else if (operator_.equals("intersection")){
			result = computeIntersection();
		} else if (operator_.equals("difference")){
			result = computeDifference();
		} else if (operator_.equals("symmetric difference")){
			result = computeSymetricDifference();
		} else if (operator_.equals("is subset")){
			result = isSubset();
		} else if (operator_.equals("is superset")){
			result = isSuperset();
		} else {
			// A discuter
			result.add(0);
		}
		
		return result;
	}
	
	private ArrayList<Integer> computeUnion(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Integer currentInt = 0;
		for (int i = 0; i < size1_; i++){
			currentInt = val1_.get(i);
			if (!result.contains(currentInt)){
				result.add(currentInt);
			}
		}
		for (int j = 0; j < size2_; j++){
			currentInt = val2_.get(j);
			if (!result.contains(currentInt)){
				result.add(currentInt);
			}
		}
		return result;
	}
	
	private ArrayList<Integer> computeIntersection(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Integer currentInt = 0;
		if (size1_ > size2_){
			for (int i = 0; i < size1_; i++) {
				currentInt = val1_.get(i);
				if (val2_.contains(currentInt) && !result.contains(currentInt)){
					result.add(currentInt);
				}
			}
		} else {
			for (int j = 0; j < size2_; j++) {
				currentInt = val2_.get(j);
				if (val1_.contains(currentInt) && !result.contains(currentInt)){
					result.add(currentInt);
				}
			}
		}
		return result;
	}
	
	private ArrayList<Integer> computeDifference(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Integer currentInt = 0;
		for (int i = 0; i < size1_; i++){
			currentInt = val1_.get(i);
			if (!val2_.contains(currentInt) && !result.contains(currentInt)){
				result.add(currentInt);
			}
		}
		return result;
	}
	
	private ArrayList<Integer> computeSymetricDifference(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> intersection = computeIntersection();
		Integer currentInt = 0;
		for (int i = 0; i < size1_; i++){
			currentInt = val1_.get(i);
			if (!intersection.contains(currentInt) && !result.contains(currentInt)){
				result.add(currentInt);
			}
		}
		for (int i = 0; i < size2_; i++){
			currentInt = val2_.get(i);
			if (!intersection.contains(currentInt) && !result.contains(currentInt)){
				result.add(currentInt);
			}
		}
		return result;
	}
	
	private ArrayList<Integer> isSubset(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Integer currentInt = 0;
		Integer isSubset = 1;
		for (int i = 0; i < size1_; i++){
			currentInt = val1_.get(i);
			if (!val2_.contains(currentInt)){
				isSubset = 0;
			}
		}
		result.add(isSubset);
		return result;
	}
	
	private ArrayList<Integer> isSuperset(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Integer currentInt = 0;
		Integer isSuperset = 1;
		for (int i = 0; i < size2_; i++){
			currentInt = val2_.get(i);
			if (!val1_.contains(currentInt)){
				isSuperset = 0;
			}
		}
		result.add(isSuperset);
		return result;
	}
	
	private ArrayList<Integer> val1_;
	private ArrayList<Integer> val2_;
	Integer size1_;
	Integer size2_;
	private String operator_;
	

}
