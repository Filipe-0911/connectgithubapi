
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.githubconnect.classes.ConnectApi;
import br.com.githubconnect.classes.ProjectList;
import br.com.githubconnect.classes.User;
import br.com.githubconnect.records.ProjectData;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(".env");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String apiToken = properties.getProperty("API_TOKEN");

        User newUser = new User("Filipe-0911", apiToken);

        ConnectApi getRepos = new ConnectApi(newUser);

        Type listType = new TypeToken<ArrayList<ProjectData>>() {
        }.getType();
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();

        List<ProjectData> listBeforeConvert = gson.fromJson(getRepos.getJson(), listType);

        ProjectList projectList = new ProjectList(listBeforeConvert, getRepos);
        
        projectList.listProjects();
        projectList.sort();
        projectList.listProjects();
    }
}