package UtilityFile;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
	
	public JiraClient jira;
	public String project;
	
	public JiraServiceProvider(String jiraUrl, String Username, String Password, String project)
	{
		BasicCredentials creds=new BasicCredentials(Username,Password);
		jira =new JiraClient(jiraUrl,creds);
		this.project=project;
	}
	
	
	public void  createJiraTicket(String issueType, String Summary, String description, String reportName)
	{
		
		try {
			FluentCreate FluentCreate=jira.createIssue(project, issueType);
			FluentCreate.field(Field.SUMMARY, Summary);
			FluentCreate.field(Field.DESCRIPTION, description);
			Issue newissue=FluentCreate.execute();
			System.out.println("New issue is created in Jira with the Id:" +newissue);
			
		} catch (JiraException e) {
			
			e.printStackTrace();
		}
		
	}

}
