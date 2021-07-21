package com.flany.paging.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/19
 * @since:
 */
fun main() {
    GlobalScope.launch {
        flow {
            emit("1111")
        }.onStart {
            println("onStart")
        }.onCompletion {
            println("onCompletion")
        }.collect {
            println(it)
        }
    }

    GlobalScope.launch(Dispatchers.Default) {
        println("launch ${Thread.currentThread().name}")
        flowOf(1, 2, 3, 4, 5).flowOn(Dispatchers.IO).collect {
            println("flowOf ${Thread.currentThread().name} - $it")
        }
        flow {
            for (i in 1..4) {
                emit(i)
            }
        }.collect {
            println("flow ${Thread.currentThread().name} - $it")
        }

        listOf("11", "22", "33").asFlow().collect {
            println("asFlow ${Thread.currentThread().name} - $it")
        }
    }

    Thread.sleep(3000)
}