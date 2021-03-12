package aplicacao_console;

import fachada.Fachada;

import modelo.Subject;
import modelo.User;
import modelo.Video;
import modelo.View;


public class Create {

    public void createSubjects() {
        try {
            System.out.println("BEGIN Create all Subjects...");

            Fachada.inicializar();

            String[] nameOfSubjects = new String[] {"necropolitica","luta de classes","malcolm x","liberalismo"};

            for (String subject: nameOfSubjects) {
                try {
                    Subject subj = Fachada.createSubject(subject);
                    System.out.println(" + create Subject -> " + subject);
                } catch (Exception e) {
                    System.out.println(" ! could not create Subject with name: " + subject + " | -> " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public void createUsers() {
        try {
            System.out.println("BEGIN Create all users...");

            Fachada.inicializar();

            String[] nameOfUsers = new String[] {
                    "karl.marx@comuna.org",
                    "friedrich.engels@comuna.org",
                    "josef.stalin@comuna.org",
                    "vladimir.lenin@comuna.org",
                    "hannah.arendt@comuna.org"};

            for (String email: nameOfUsers) {
                try {
                    User user = Fachada.createUser(email);
                    System.out.println(" + create user -> " + email);
                } catch (Exception e) {
                    System.out.println(" ! could not create User with email: " + email + " | -> " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public void createVideos() {
        try {
            System.out.println("BEGIN Create all videos...");

            Fachada.inicializar();

            String[] nameOfVideos = new String[] {
                    "Necropolítica: o desarme do pensamento crítico|https://www.youtube.com/watch?v=ukCQLNXFhQ0&ab_channel=JonesManoel",
                    "A China e os bilionários: notas sobre a luta de classes|https://www.youtube.com/watch?v=IfYnsqtfxFQ&ab_channel=JonesManoel",
                    "A filosofia política de Malcolm X|https://www.youtube.com/watch?v=DgHS_4iEK8s&ab_channel=JonesManoel",
                    "Ideologia dominante, liberalismo e senso comum|https://www.youtube.com/watch?v=6AN596vDL-8&ab_channel=JonesManoel",
                    "Teste|https://www.youtube.com/watch?v=teste"};

            for (String item: nameOfVideos) {
                try {
                    String[] nameAndLink = item.split("\\|");
                    if (nameAndLink[0].contains("Ideologia")) {
                        Video video = Fachada.createVideo(nameAndLink[1], nameAndLink[0], "liberalismo");
                    } else {
                        Video video = Fachada.createVideo(nameAndLink[1], nameAndLink[0]);
                    }
                    System.out.println(" + create video -> " + nameAndLink[0]);
                } catch (Exception e) {
                    System.out.println(" ! could not create Video with name and link: " + item + " | -> " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public void createViews() {
        try {
            System.out.println("BEGIN put all views...");

            Fachada.inicializar();

            String[] items = new String[] {
                    "5|josef.stalin@comuna.org|https://www.youtube.com/watch?v=ukCQLNXFhQ0&ab_channel=JonesManoel",
                    "5|josef.stalin@comuna.org|https://www.youtube.com/watch?v=IfYnsqtfxFQ&ab_channel=JonesManoel",
                    "4|josef.stalin@comuna.org|https://www.youtube.com/watch?v=DgHS_4iEK8s&ab_channel=JonesManoel",
                    "5|vladimir.lenin@comuna.org|https://www.youtube.com/watch?v=6AN596vDL-8&ab_channel=JonesManoel"};

            for (String item: items) {
                try {
                    String[] noteEmailLink = item.split("\\|");
                    View view = Fachada.toView(
                            noteEmailLink[2],
                            noteEmailLink[1],
                            Integer.parseInt(noteEmailLink[0]));
                    System.out.println(" + put view -> " + item);
                } catch (Exception e) {
                    System.out.println(" ! could not create view: " + item + " | -> " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            Fachada.finalizar();
        }
        System.out.println("END...");
    }

    public Create() {
        try {
            createSubjects();
        } catch (Exception e) 	{
            System.out.println(e.getMessage());
        }

        try {
            createUsers();
        } catch (Exception e) 	{
            System.out.println(e.getMessage());
        }

        try {
            createVideos();
        } catch (Exception e) 	{
            System.out.println(e.getMessage());
        }

        try {
            createViews();
        } catch (Exception e) 	{
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Create();
    }

}
