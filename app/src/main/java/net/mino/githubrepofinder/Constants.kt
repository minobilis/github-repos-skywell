package net.mino.githubrepofinder


interface Constants {
    interface NETWORK {
        interface HOST {
            companion object {
                const val BASE_URL = "https://api.github.com"
            }
        }

        interface ENDPOINT {
            companion object {
                const val SEARCH_REPOSITORIES = "/search/repositories"
            }
        }
    }

    interface PREFERENCES {
        companion object {
            const val LAST_QUERY = "last_query"
        }
    }
}
