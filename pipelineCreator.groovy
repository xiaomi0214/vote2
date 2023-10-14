// get all DSL config http://jenkins.wangwei.devopscamp.us/plugin/job-dsl/api-viewer/index.html
multibranchPipelineJob("${Name}") {
    branchSources {
        branchSource {
            source {
                github {
                    id('github')
                    repoOwner("xiaomi0214")
                    configuredByUrl(false)
                    repository("vote2")
                    repositoryUrl("https://github.com/xiaomi0214/vote2.git")
                    credentialsId('github-pull-secret')

                    traits {
                        gitHubBranchDiscovery {
                            strategyId(1)
                        }
                        gitHubPullRequestDiscovery {
                            strategyId(2)
                        }
                    }
                }
            }
        }
        factory {
            workflowBranchProjectFactory {
                scriptPath("${jenkinsfile}")
            }
        }
    }
}