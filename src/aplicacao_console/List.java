package aplicacao_console;

import fachada.Fachada;

import modelo.Subject;
import modelo.User;
import modelo.Video;


public class List {

    private String separator = "--> ";

    public void listSubjects() {
        try {
            System.out.println("BEGIN list of subjects...");

            Fachada.inicializar();

            for(Subject subject : Fachada.listAllSubjects() )
                System.out.println(this.separator + subject);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public void listUsers() {
        try {
            System.out.println("BEGIN list of users...");

            Fachada.inicializar();

            for(User user : Fachada.listAllUsers() )
                System.out.println(this.separator + user);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public void listVideos() {
        try {
            System.out.println("BEGIN list of videos...");

            Fachada.inicializar();

            for(Video video : Fachada.listAllVideos() )
                System.out.println(this.separator + video);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public List(){
        try {
            listSubjects();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            listUsers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            listVideos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new List();
    }
}
