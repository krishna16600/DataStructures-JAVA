import java.util.ArrayList;

public class Map<K, V> {

	// ArrayList of type MapNode which is further generic
	ArrayList<MapNode<K, V>> buckets;
	int size;
	int numBuckets;

	public Map() {
		numBuckets = 5;
		buckets = new ArrayList<MapNode<K, V>>();
		// adding null to every index
		for (int i = 0; i < 5; i++) {
			buckets.add(null);
		}

	}

	// HashFunction -> generate a hashcode and CF convert it to an Integer which
	// lies within the arraylist's size
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		// compression function 
		return hashCode % numBuckets;
	}
	public double loadFactor() {
		return (1.0*size)/numBuckets;
	}
	
	public void rehash() {
		System.out.println("Rehashing: buckets "+numBuckets+" size: "+size);
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<MapNode<K,V>>();
		for(int i = 0 ;i < 2*numBuckets ; i++) {
			buckets.add(null);
		}
		size = 0;
		numBuckets*= 2;
		for(int i=0;i<temp.size();i++)
		{
			MapNode<K, V> head = temp.get(i);
			while(head!=null)
			{
				K key = head.key;
				V value = head.value;
				insert(key,value);
				head = head.next;
			}
		}
	}

	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);

		/*
		 * Traversing the Linked List if we get same entry of a key we should update the
		 * value of it
		 */
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		/*
		 * what if we reach here, means there's no duplicate key of which we can update
		 * the value we need to create a new node, put it before the head of the linked
		 * list basically insert at first is happening!
		 */
		head = buckets.get(bucketIndex);
		MapNode<K, V> newNode = new MapNode<K, V>(key, value);
		size++;
		newNode.next = head;
		buckets.set(bucketIndex, newNode);
		double loadFactor = (1.0 * size) / numBuckets;
		if (loadFactor > 0.7) {
			rehash();
		}

	}

	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);

		/*
		 * Traversing the Linked List if we get same entry of a key we should update the
		 * value of it
		 */
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while (head != null) {
			if (head.key.equals(key)) {
				size--;
				if (prev == null) {
					buckets.set(bucketIndex, head.next);
				} else {
					prev.next = head.next;
				}
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}

	public int size() {
		return size;
	}
}
