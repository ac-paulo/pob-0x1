package aplicacao_console;

import fachada.Fachada;


public class Update {

    public void updateSubjects() {
        try {
            System.out.println("BEGIN update Subjects...");

            Fachada.inicializar();

            String[] nameOfSubjects = new String[] {"necropolitica", "necropolítica"};

            for (String subject: nameOfSubjects) {
                try {
                    Fachada.updateSubject(subject, subject + "_");
                    System.out.println(" = update Subject -> " + subject + "_");
                } catch (Exception e) {
                    System.out.println(" ! could not update Subject with name: " + subject + " | -> " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public void updateUsers() {
        try {
            System.out.println("BEGIN update users...");

            Fachada.inicializar();

            String[] nameOfEmails = new String[] {"karl.marx@comuna.org", "hannah.arendt@comuna.org"};

            for (String email: nameOfEmails) {
                try {
                    Fachada.updateUser(email, email + ".edit");
                    System.out.println(" = update Subject -> " + email + ".edit");
                } catch (Exception e) {
                    System.out.println(" ! could not update user with email: " + email + " | -> " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public Update(){
        try {
            updateSubjects();
        } catch (Exception e) 	{
            System.out.println(e.getMessage());
        }
        try {
            updateUsers();
        } catch (Exception e) 	{
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Update();
    }

}
