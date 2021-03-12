package fachada;

import java.util.ArrayList;
import java.util.List;

import modelo.Subject;
import modelo.User;
import modelo.Video;
import modelo.View;

import dao.DAO;

import dao.DAOView;
import dao.DAOVideo;
import dao.DAOUser;
import dao.DAOSubject;

public class Fachada {
    private static DAOView daoView = new DAOView();
    private static DAOVideo daoVideo = new DAOVideo();
    private static DAOUser daoUser = new DAOUser();
    private static DAOSubject daoSubject = new DAOSubject();


    public static void inicializar(){
        DAO.open();
    }
    public static void finalizar(){
        DAO.close();
    }
    
    public static List<View> listAllViews() {
        return daoView.readAll();
    }

    public static List<Subject> listAllSubjects() {
        return daoSubject.readAll();
    }

    public static Subject createSubject(String word) throws Exception {
        DAO.begin();

        Subject subject = daoSubject.read(word);
        if ( subject != null ) {
            DAO.rollback();
            throw new Exception("the Subject has already been created... " + word);
        }
        subject = new Subject(word);

        daoSubject.create(subject);
        DAO.commit();

        return subject;
    }

    public static void deleteSubject(String word) throws Exception {
        DAO.begin();

        Subject subject = daoSubject.read(word);
        if ( subject == null ) {
            DAO.rollback();
            throw new Exception("Subject not exists -> " + word);
        }

        daoSubject.delete(subject);
        DAO.commit();
    }

    public static Subject updateSubject(String word, String newWord) throws Exception {
        DAO.begin();

        Subject subject = daoSubject.read(word);
        if ( subject == null ) {
            DAO.rollback();
            throw new Exception("Subject not exists -> " + word);
        }

        subject.setWord(newWord);
        subject = daoSubject.update(subject);
        DAO.commit();

        return subject;
    }

    public static User createUser(String email) throws  Exception{
        DAO.begin();

        User user = daoUser.read(email);
        if( user != null ) {
            DAO.rollback();
            throw new Exception("User already exists -> " + email);
        }

        user = new User(email);
        daoUser.create(user);
        DAO.commit();

        return user;
    }

    public static List<User> listAllUsers() {
        return daoUser.readAll();
    }

    public static void deleteUser(String email) throws Exception {
        DAO.begin();

        User user = daoUser.read(email);
        if ( user == null ) {
            DAO.rollback();
            throw new Exception("User not exists -> " + email);
        }

        daoUser.delete(user);
        DAO.commit();
    }

    public static User updateUser(String email, String newEmail) throws Exception {
        DAO.begin();

        User user = daoUser.read(email);
        if ( user == null ) {
            DAO.rollback();
            throw new Exception("User not exists -> " + email);
        }

        user.setEmail(newEmail);
        user = daoUser.update(user);
        DAO.commit();

        return user;
    }

    public static Video createVideo(String link, String name) throws  Exception {
        DAO.begin();

        Video video = daoVideo.read(link);
        if( video != null ) {
            DAO.rollback();
            throw new Exception("Video already exists -> " + name);
        }
        video = new Video(link, name);

        daoVideo.create(video);
        DAO.commit();

        return video;
    }

    public static Video createVideo(String link, String name, String word) throws  Exception {
        DAO.begin();

        Video video = createVideo(link, name);

        try {
            Subject subject = createSubject(word);
            subject.put(video);
            daoSubject.update(subject);
            daoVideo.update(video);
            DAO.commit();
        } catch (Exception e) {
            Subject subject = daoSubject.read(word);
            video.put(subject);
            subject.put(video);
            daoSubject.update(subject);
            daoVideo.update(video);
            DAO.commit();
        }

        return video;
    }

    public static List<Video> listAllVideos() {
        return daoVideo.readAll();
    }

    public static void addSubject(String link, String word) throws Exception {
        DAO.begin();

        Video video = daoVideo.read(link);
        if ( video == null ) {
            DAO.rollback();
            throw new Exception("Video with link does not exist ->" + link);
        }

        try {
            Subject subject = createSubject(word);
            subject.put(video);
            daoSubject.update(subject);
            daoVideo.update(video);
            DAO.commit();
        } catch (Exception e) {
            Subject subject = daoSubject.read(word);
            subject.put(video);
            daoSubject.update(subject);
            video.put(subject);
            daoVideo.update(video);
            DAO.commit();
        }
    }

    public static View createView(Integer note, User user, Video video) throws  Exception{
        DAO.begin();
        int cont=0;

        for (View t : daoView.readAll())
            cont++;
        cont++;

        View view = new View(cont, note, user, video);

        video.put(view);
        user.put(view);

        daoView.create(view);
        daoVideo.update(video);
        daoUser.update(user);

        DAO.commit();

        return view;
    }

    public static View toView(String link, String email, Integer note) throws Exception {
        Video video = daoVideo.read(link);
        if ( video == null ) {
            DAO.rollback();
            throw new Exception("Video with link does not exist -> " + link);
        }

        User user = daoUser.read(email);
        if ( user == null ) {
            DAO.rollback();
            throw new Exception("User not exists -> " + email);
        }

        return createView(note, user, video);
    }

    public static List<User> getUsersByVideo(String link) throws Exception {
        Video video = daoVideo.read(link);
        if ( video == null ) {
            DAO.rollback();
            throw new Exception("Video with link does not exist ->" + link);
        }
        List<User> users = new ArrayList<User>();
        for (View view: video.getViews()) {
            users.add(view.getUserObject());
        }
        return users;
    }

    public static List<Video> getVideosByUser(String email) throws Exception {
        User user = daoUser.read(email);
        if ( user == null ) {
            DAO.rollback();
            throw new Exception("User with email does not exist -> " + email);
        }

        List<Video> videos = new ArrayList<Video>();
        for (View view: user.getViews()) {
            videos.add(view.getVideo());
        }
        return videos;
    }

    public static List<Video> getVideosBySubject(String word) throws Exception {
        Subject subject = daoSubject.read(word);
        if ( subject == null ) {
            DAO.rollback();
            throw new Exception("Subject with word does not exist -> " + word);
        }

        return subject.getVideos();
    }

}
