package br.com.githubconnect.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import br.com.githubconnect.records.ProjectData;

public class ProjectList extends ArrayList<Project>{
    ArrayList<Project> projectList;

    public ProjectList(List<ProjectData> classList, ConnectApi getRepos) {
        projectList = new ArrayList<>();

        _convertProjectDataToProject(classList);
    }

    public void listProjects() {
        if(this.projectList.size() > 0){
            for (Project projeto : this.projectList) {
                System.out.println(projeto);
            }
    
            System.out.println("You have %d public projects in your account".formatted(this.projectList.size()));
            
        } else {
            System.out.println("You don't have any projects in your GitHub account");;
        }
        
    }

    private void _convertProjectDataToProject(List<ProjectData> classList) {
        try {
            for (ProjectData project : classList) {
                Project pro = new Project(project);
    
                projectList.add(pro);
            }

        } catch (NullPointerException e) {
            System.out.println("An error ocurred: " + e);
        }
        
    }

    public void sort () {
        Collections.sort(this.projectList);
    }

}
