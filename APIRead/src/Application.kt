import org.eclipse.egit.github.core.IRepositoryIdProvider
import org.eclipse.egit.github.core.RepositoryCommit
import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.CommitService
import org.eclipse.egit.github.core.service.RepositoryService
import org.eclipse.egit.github.core.service.UserService
import java.io.File

fun main(){
        val username = "Mushman2"
        val loginToken = "326363b43560598c7d91ecf2e128a2b64123ae6a"
        val client = GitHubClient()
        client.setCredentials(username, loginToken)
//
        val userService = UserService(client)
//        println("Emails: ")
//        for (email in userService.emails)
//            println("  $email")
//        println("Followers: ")
//        for (f in userService.followers)
//            println("  ${f.login}")
//
//        println("Repositories:")
        val repositoryService = RepositoryService(client)
        val commitService = CommitService(client)
//        for (repo in service.repositories) {
//            println("  " + repo.name + ":\n    Watchers: " + repo.watchers + "\n    Private?: " + repo.isPrivate + " \n    Branches: ")
//            for (branch in service.getBranches(repo)) println("      " + branch.name)
//        }

        val repo = repositoryService.getRepository("mbostock", "d3")

        println(repo.createdAt)
        val commitsList = commitService.getCommits({repo.generateId()})
        val file = File("commits.csv")
        for (commitSmall in commitsList){
                val commit = commitService.getCommit({repo.generateId()},  commitSmall.sha)
                if(commit.stats != null) {
                        //println("${commit.commit.author.date}, ${commit.commit.author.name}, ${commit.commit.committer.name}, ${commit.stats.additions}, ${commit.stats.deletions}")
                        file.appendText("${commit.commit.author.date}, ${commit.commit.author.name}, ${commit.commit.committer.name}, ${commit.stats.additions}, ${commit.stats.deletions}, ${commit.stats.total}, ${commit.commit.commentCount}, ${commit.commit.message.length}\n")
                }
        }
    }