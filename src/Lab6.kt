
fun sort(array: Array<Int>) {
    for(i in 0 until array.size)
        for(j in i until array.size)
            if(array[i] > array[j]) {
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
}