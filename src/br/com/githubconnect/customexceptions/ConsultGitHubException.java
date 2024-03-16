package br.com.githubconnect.customexceptions;

public class ConsultGitHubException extends RuntimeException {
    public String message;

    public ConsultGitHubException(String message)  {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }

    
}
