package br.com.githubconnect.classes;

import br.com.githubconnect.records.ProjectData;

public class Project implements Comparable<Project>{
    private String name; //name
    private int projectId;
    private String urlProject; //html_url
    private String languageUsedInProject; //language

    private String owner; //owner.login
    private int ownerId;

    public Project(String name, String owner, String urlProject, String languageUsedInProject) {
        this.name = name;
        this.owner = owner;
        this.urlProject = urlProject;
        this.languageUsedInProject = languageUsedInProject;
    }

    public Project (ProjectData project) {
        this.name = project.name();
        this.owner = project.owner().login();
        this.urlProject = project.html_url();
        this.projectId = project.id();
        this.ownerId = project.owner().id();
        this.languageUsedInProject = project.language();
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getUrlProject() {
        return urlProject;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getLanguageUsedInProject() {
        if (languageUsedInProject != null) {
            return languageUsedInProject.toUpperCase();

        }
        return languageUsedInProject;
    }

    public int getOwnerId() {
        return ownerId;
    }

    @Override
    public boolean equals(Object project) {
        Project otherProject = (Project) project;

        return this.getProjectId() == otherProject.getProjectId();
    }

    @Override
    public String toString() {
        return "Project ID: %d; Language: %s; Project: %s; URL Project: %s || Owner: %s; Owner ID: %d"
        .formatted(this.getProjectId(), this.getLanguageUsedInProject(), this.getName(), this.getUrlProject(), this.getOwner(), this.getOwnerId());
    }

    @Override
    public int compareTo(Project otherProject) {
        return Integer.compare(this.getProjectId(), otherProject.getProjectId());
    }

}
