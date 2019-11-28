
import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.CommitService
import org.eclipse.egit.github.core.service.RepositoryService
import org.eclipse.egit.github.core.service.UserService
import java.io.File
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun main(){
        val username = "Mushman2"
        val loginToken = "326363b43560598c7d91ecf2e128a2b64123ae6a"
        val client = GitHubClient()
        client.setCredentials(username, loginToken)

        val repositoryService = RepositoryService(client)
        val commitService = CommitService(client)
        val repo = repositoryService.getRepository("mbostock", "d3")

        println(repo.createdAt)
        val commitsList = commitService.getCommits({repo.generateId()})
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val file = File("commits.csv")
        file.appendText("date,author,committer,additions,deletions,total,comments,messageLength\n")

        for (commitSmall in commitsList){
                val commit = commitService.getCommit({repo.generateId()},  commitSmall.sha)
                if(commit.stats != null) {
                        //println("${commit.commit.author.date}, ${commit.commit.author.name}, ${commit.commit.committer.name}, ${commit.stats.additions}, ${commit.stats.deletions}")
                        file.appendText("${commit.commit.author.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter)},\"${commit.commit.author.name}\",\"${commit.commit.committer.name}\",${commit.stats.additions},${commit.stats.deletions},${commit.stats.total},${commit.commit.commentCount},${commit.commit.message.length}\n")
                }
        }
    }