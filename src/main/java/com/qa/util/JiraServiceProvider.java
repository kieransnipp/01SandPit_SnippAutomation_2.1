package com.qa.util;
//package com.qa.util;
//
//import net.rcarz.jiraclient.BasicCredentials;
//import net.rcarz.jiraclient.Field;
//import net.rcarz.jiraclient.Issue;
//import net.rcarz.jiraclient.Issue.FluentCreate;
//import net.rcarz.jiraclient.JiraClient;
//import net.rcarz.jiraclient.JiraException;
//
//public class JiraServiceProvider {
//
//	public JiraClient jira;
//	public String project;
//
//	public JiraServiceProvider(String jiraUrl, String userName, String passWord, String project) {
//		BasicCredentials creds = new BasicCredentials(userName, passWord);
//		jira = new JiraClient(jiraUrl, creds);
//		this.project = project;
//	}
//
//	public void createJiraTicket(String issueType, String summary, String description, String reporterName) {
//
//		try {
//			FluentCreate fluentCreate = jira.createIssue(project, issueType);
//			fluentCreate.field(Field.SUMMARY, summary);
//			fluentCreate.field(Field.DESCRIPTION, description);
//			//fluentCreate.field(Field.REPORTER, reporterName);
//
//			Issue newIssue = fluentCreate.execute();
//			System.out.println("New Issue created with ID:" + newIssue);
//			
//			
//		} catch (JiraException e) {
//			e.printStackTrace();
//		}
//	}
//}
