import androidx.collection.mutableIntObjectMapOf
import kotlin.random.Random

fun main() {
	for (i in 0..Int.MAX_VALUE) {
		println("-".repeat(100))
		println("Seed $i")

		val map = mutableIntObjectMapOf<Unit>()

		var firstKey = 0
		var lastKey = 0
		fun insert(count: Int) {
			repeat(count) {
				val key = ++lastKey
				println("Insert $key")
				if (map.put(key, Unit) != null) {
					throw AssertionError("Failed inserting $lastKey")
				}
			}
		}
		fun remove(count: Int) {
			repeat(count) {
				val key = ++firstKey
				println("Remove $key")
				map.remove(key)
			}
		}

		val r = Random(i)
		repeat(100) {
			insert(count = r.nextInt(1, 30))
			remove(count = r.nextInt(map.size))
		}
	}
}
