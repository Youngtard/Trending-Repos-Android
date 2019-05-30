package com.youngtard.githubtrendingandroid.model

data class Resp(val total_count: Int, val incomplete_results: Boolean, val items: MutableList<Repo>) {
}