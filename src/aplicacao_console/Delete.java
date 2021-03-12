package aplicacao_console;

import fachada.Fachada;

import modelo.Subject;
import modelo.User;


public class Delete {

    public void deleteSubjects() {
        try {
            System.out.println("BEGIN delete Subjects...");

            Fachada.inicializar();

            String[] nameOfSubjects = new String[] {"necropolitica", "necropolítica"};

            for (String subject: nameOfSubjects) {
                try {
                    Fachada.deleteSubject(subject);
                    System.out.println(" - deleted Subject -> " + subject);
                } catch (Exception e) {
                    System.out.println(" ! could not delete Subject with name: " + subject + " | -> " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public void deleteUsers() {
        try {
            System.out.println("BEGIN delete users...");

            Fachada.inicializar();

            String[] nameOfEmails = new String[] {"hannah.arendt@comuna.org", "karl.marxx@comuna.org"};

            for (String email: nameOfEmails) {
                try {
                    Fachada.deleteUser(email);
                    System.out.println(" - deleted user -> " + email);
                } catch (Exception e) {
                    System.out.println(" ! could not delete user with email: " + email + " | -> " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public Delete(){
        try {
            deleteSubjects();
        } catch (Exception e) 	{
            System.out.println(e.getMessage());
        }
        try {
            deleteUsers();
        } catch (Exception e) 	{
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Delete();
    }

}
