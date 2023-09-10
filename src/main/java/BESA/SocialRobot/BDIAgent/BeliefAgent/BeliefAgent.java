package BESA.SocialRobot.BDIAgent.BeliefAgent;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.PsychologicalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.PhysicalState;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.UserProfile;
import BESA.SocialRobot.BDIAgent.BeliefAgent.WorldModel.WorldModel;
import rational.data.InfoData;
import rational.mapping.Believes;

/**
 *
 * @author juans
 */
public class BeliefAgent implements Believes {

    private InteractionState interactionState;
    private PsychologicalState psychologicalState;
    private PhysicalState physicalState;
    private UserProfile userProfile;
    private WorldModel worldModel;

    public BeliefAgent() {
        interactionState = new InteractionState();
        psychologicalState = new PsychologicalState();
        physicalState = new PhysicalState();
        userProfile = new UserProfile();
        worldModel = new WorldModel();
    }

    // AQUI SE MANDA LO DE INFORMATIONFLOW
    // Aqui se accede a BD y se pide info de otros believes.
    @Override
    public boolean update(InfoData si) {
        return true;
    }

    //public void feedbackActivity(double voiceFeedback) {
    //    double emotionFeedback = 0.0, emotionFeedbackAux = 0;
    //    ResPwAActivity activity = bEstadoActividad.getActividadActual();
    //    Object activityInCourse = null;
    //    List<Antecedente> antecedents = RESPwABDInterface.getActecedents();
    //    emotionFeedback = bEstadoEmocionalPwA.getFeedbackEmotion();
    //    emotionFeedback = aproximateEmotionValue(emotionFeedback);
//
    //    List<Antecedente> antecedentsForFeedback = getAntecedentsForFeedback(emotionFeedback, voiceFeedback,
    //            antecedents);
    //    System.out.println("ACTIVIDAD ACTUAL" + activity);
//
    //    switch (activity) {
    //        case CUENTERIA:
    //            activityInCourse = (PreferenciaXCuento) bEstadoActividad.getCuentoActual();
    //            ModeloRetroalimentacion<PreferenciaXCuento> modeloRetroCuento = new ModeloRetroalimentacion<>(
    //                    (PreferenciaXCuento) activityInCourse);
    //            modeloRetroCuento.activityFeedback(antecedentsForFeedback);
    //            break;
//
    //        case MUSICOTERAPIA:
    //            activityInCourse = (PreferenciaXCancion) bEstadoActividad.getCancionActual();
    //            ModeloRetroalimentacion<PreferenciaXCancion> modelRetroCancion = new ModeloRetroalimentacion<>(
    //                    (PreferenciaXCancion) activityInCourse);
    //            modelRetroCancion.activityFeedback(antecedentsForFeedback);
    //            break;
    //        case EJERCICIO:
    //            // save to bd : )
    //            PerfilEjercicio currPerfilEjercicio = bPerfilPwA.getPerfil().getPerfilEjercicio();
    //            if (currPerfilEjercicio != null) {
    //                for (int i = 0; i < currPerfilEjercicio.getEjercicioList().size(); i++) {
    //                    // currPerfilEjercicio.getEjercicioList().get(i).setPreferencia(voiceFeedback);
    //                    // System.out.println("Entró acá: " + voiceFeedback);
    //                    // RESPwABDInterface.updateExercise(currPerfilEjercicio.getEjercicioList().get(i));
    //                }
    //            }
    //            break;
    //    }
//
    //}
//
    //private List<Antecedente> getAntecedentsForFeedback(double emotionFeedback, double voiceFeedback,
    //        List<Antecedente> antecedents) {
//
    //    List<Antecedente> antecedentsForFeedback = new ArrayList<>();
    //    for (int i = 0; i < antecedents.size(); i++) {
    //        if (antecedents.get(i).getEtiqueta().equals("EMOTIONFEEDBACK")
    //                && antecedents.get(i).getValor() == emotionFeedback) {
    //            antecedentsForFeedback.add(antecedents.get(i));
    //        } else {
    //            if (antecedents.get(i).getEtiqueta().equals("VOICEFEEDBACK")
    //                    && antecedents.get(i).getValor() == voiceFeedback) {
    //                antecedentsForFeedback.add(antecedents.get(i));
    //            }
    //        }
    //    }
//
    //    return antecedentsForFeedback;
    //}

    //private double aproximateEmotionValue(double emotionFeedback) {
    //    double aproximation = 0.0;
    //    final double VERY_PLEASANT = 1;
    //    final double PLEASANT = 0.65;
    //    final double LITTLE_PLEASANT = 0.35;
    //    final double VERY_UNPLEASANT = -1;
    //    final double UNPLEASANT = -0.65;
    //    final double LITTLE_UNPLEASANT = -0.35;
    //    final double ZERO = 0.0;
//
    //    if (emotionFeedback > PLEASANT) {
    //        aproximation = VERY_PLEASANT;
    //    } else {
    //        if (emotionFeedback > LITTLE_PLEASANT) {
    //            aproximation = PLEASANT;
    //        } else {
    //            if (emotionFeedback > ZERO) {
    //                aproximation = LITTLE_PLEASANT;
    //            } else {
    //                if (emotionFeedback < UNPLEASANT) {
    //                    aproximation = VERY_UNPLEASANT;
    //                } else {
    //                    if (emotionFeedback < LITTLE_PLEASANT) {
    //                        aproximation = UNPLEASANT;
    //                    } else {
    //                        aproximation = LITTLE_UNPLEASANT;
    //                    }
    //                }
    //            }
    //        }
    //    }
//
    //    return aproximation;
    //}

    //public Object getActivityInCourse() {
    //    ResPwAActivity activity = bEstadoActividad.getActividadActual();
    //    Object activityInCourse = null;
//
    //    switch (activity) {
    //        case CUENTERIA:
    //            activityInCourse = (PreferenciaXCuento) bEstadoActividad.getCuentoActual();
    //            break;
//
    //        case MUSICOTERAPIA:
    //            activityInCourse = (PreferenciaXCancion) bEstadoActividad.getCancionActual();
    //            break;
    //    }
//
    //    return activityInCourse;
//
    //}

    //private PerfilPwa getPerfilBD(String cedula) {
    //    // conectarConBD
    //    return getFromDB(cedula);
    //}
//
    //PerfilPwa getFromDB(String cedula) {
    //    PerfilPwa perfil = RESPwABDInterface.getProfile(cedula);
    //    return perfil;
    //}

    @Override
    public Believes clone() throws CloneNotSupportedException {
        return this;
    }

    public InteractionState getInteractionState() {
        return interactionState;
    }

    public void setInteractionState(InteractionState interactionState) {
        this.interactionState = interactionState;
    }

    public PsychologicalState getPsychologicalState() {
        return psychologicalState;
    }

    public void setPsychologicalState(PsychologicalState psychologicalState) {
        this.psychologicalState = psychologicalState;
    }

    public PhysicalState getPhysicalState() {
        return physicalState;
    }

    public void setPhysicalState(PhysicalState physicalState) {
        this.physicalState = physicalState;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public WorldModel getWorldModel() {
        return worldModel;
    }

    public void setWorldModel(WorldModel worldModel) {
        this.worldModel = worldModel;
    }

    

}
