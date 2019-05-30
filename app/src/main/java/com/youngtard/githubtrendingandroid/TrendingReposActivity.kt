package com.youngtard.githubtrendingandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.youngtard.githubtrendingandroid.adapter.ReposAdapter
import com.youngtard.githubtrendingandroid.model.Repo
import com.youngtard.githubtrendingandroid.model.Resp
import com.youngtard.githubtrendingandroid.network.GithubApiService
import kotlinx.android.synthetic.main.activity_trending_repos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TrendingReposActivity : AppCompatActivity() {
    private val gson = GsonBuilder().setLenient().create()
    private val baseURL = "https://api.github.com/"
    private val retrofit = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create(gson)).build()
    private val githubApiService = retrofit.create(GithubApiService::class.java)

    private val reposAdapter = ReposAdapter(ArrayList(0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trending_repos)

        supportActionBar?.title = "Repos"

        progress_bar.visibility = View.VISIBLE

        val reposLayoutManager = LinearLayoutManager(applicationContext)

        rv_list_of_trending_repos.apply {
            setHasFixedSize(true)

            layoutManager = reposLayoutManager

            adapter = reposAdapter
        }



    }


    override fun onStart() {
        super.onStart()



    }

    override fun onResume() {
        super.onResume()
        progress_bar.visibility = View.VISIBLE


        val reposInResponse: MutableList<Repo> = arrayListOf()

        val kotlinReposCall = githubApiService.getTrendingKotlin()
        val javaReposCall = githubApiService.getTrendingJava()

        kotlinReposCall.enqueue(object: Callback<Resp> {
            override fun onResponse(call: Call<Resp>, response: Response<Resp>) {
                if (response.isSuccessful) {
                    progress_bar.visibility = View.GONE

                    val resp =  response.body()
//                    val items = resp.items
//                    reposAdapter.reposData =  items.sortedBy{repo -> repo.name}
                    reposInResponse.addAll(resp!!.items)
                    reposAdapter.reposData = reposInResponse.sortedByDescending{ repo -> repo.stargazers_count }

                } else {
                    Toast.makeText(applicationContext, response.code().toString(), Toast.LENGTH_SHORT).show()

                }


            }

            override fun onFailure(call: Call<Resp>, t: Throwable) {
                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_SHORT).show()

            }
        })

        javaReposCall.enqueue(object: Callback<Resp> {
            override fun onResponse(call: Call<Resp>, response: Response<Resp>) {
                if (response.isSuccessful) {
                    progress_bar.visibility = View.GONE

                    val resp =  response.body()
//                    val items = resp.items
//                    reposAdapter.reposData =  items.sortedBy{repo -> repo.name}
                    reposInResponse.addAll(resp!!.items)
                    reposAdapter.reposData = reposInResponse.sortedByDescending{ repo -> repo.stargazers_count  }

                } else {
                    Toast.makeText(applicationContext, response.code().toString(), Toast.LENGTH_SHORT).show()

                }


            }

            override fun onFailure(call: Call<Resp>, t: Throwable) {
                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_SHORT).show()

            }
        })

//        reposAdapter.reposData = reposInResponse.sortedBy { repo -> repo.name  }


    }
}
