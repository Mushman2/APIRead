import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.RepositoryService
import java.util.*


fun main(){
    println("Please enter the username of the developer you wish to know about:")
    val username = readLine()
    val client = GitHubClient()
    //client.setCredentials("Mushman2", "passw0rd");
    val service = RepositoryService()
    for (repo in service.getRepositories(username)) {
        println("\n" + repo.name + " Watchers: " + repo.watchers + " Private?: " + repo.isPrivate + " \nBranches: ")
        for (branch in service.getBranches(repo)) println("   " + branch.name)
    }

}