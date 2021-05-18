@file:Suppress("FunctionName")

package analytics_html_img

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

internal object Common {
    const val GITHUB_API = "https://api.github.com"
    fun START_SECTION(tagName: String = "HTI") = "<!--START_SECTION:$tagName-->"
    fun END_SECTION(tagName: String = "HTI") = "<!--END_SECTION:$tagName-->"
    const val USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:88.0) Gecko/20100101 Firefox/88.0"
}
internal val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer(
            Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
        )
    }
}
internal data class GithubFileContent(
    val decryptedContent: String,
    val sha: String
)