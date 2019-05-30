package com.youngtard.githubtrendingandroid.model


data class Repo(val full_name: String, val name: String, val description: String, val language: String, val stargazers_count: Int, val owner: Owner) {

}