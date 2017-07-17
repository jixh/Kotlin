package com.jktaihe.engine.utils

/**
 * Created by hzjixiaohui on 2017-6-14.
 */
object CollectionUtils{

    fun test(){
        val list = listOf(1,2,3,4)
        list.any(){ it %2 == 0}
        list.all { it >0 }
        list.count { it %2 == 0 }
        list.fold(2){ total,next  -> total + next}
        list.foldRight(2){total,next -> total + next}
        list.reduce { acc, i -> acc +i }
        list.reduceRight { acc, i -> acc +i }
        list.forEach{}
        list.forEachIndexed{index,i-> {}}
        list.max()
        list.maxBy { it - 2 }
        list.min()
        list.none(){it == 2}
        list.sumBy {  it % 2 }
        list.subList(2,3)
        list.dropLast(2)
        list.dropWhile { it >2 }
        list.dropLastWhile { it < 2 }
        list.filter { it == 2 }
        list.filterNot { it == 2 }
        list.filterNotNull()
        list.slice(listOf(2))
        list.take(2)
        list.takeLast(2)
        list.takeWhile { it > 2  }
        list.takeLastWhile { it < 2 }

        list.flatMap { listOf(it ,it+2) }
        list.groupBy {  }
        list.map { it * 2 }
    }
}