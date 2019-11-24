import org.eclipse.egit.github.core.client.GitHubClient
            import org.eclipse.egit.github.core.service.RepositoryService
            import org.eclipse.egit.github.core.service.UserService

    fun main(){
        val username = "Mushman2"
        val loginToken = "bd20a7cd1937a0804f590dbbe9c270c8640f0451"
        val client = GitHubClient()
        client.setCredentials(username, loginToken)

        val userService = UserService(client)
        println("Emails: ")
        for (email in userService.emails)
            println("  $email")
        println("Followers: ")
        for (f in userService.followers)
            println("  ${f.login}")

        println("Repositories:")
        val service = RepositoryService(client)
        for (repo in service.repositories) {
            println("  " + repo.name + ":\n    Watchers: " + repo.watchers + "\n    Private?: " + repo.isPrivate + " \n    Branches: ")
            for (branch in service.getBranches(repo)) println("      " + branch.name)
        }
}