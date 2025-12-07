package com.example.ibphysicsai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ibphysicsai.databinding.FragmentTheoryBinding
import com.example.ibphysicsai.data.model.Topic

class TheoryFragment : Fragment() {
    private var _binding: FragmentTheoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTheoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val grade = arguments?.getInt("grade") ?: 9
        binding.tvGradeTitle.text = "Grade $grade – Physics Topics"
        val sections = getSectionsForGrade(grade)
        binding.rvTopics.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = SectionAdapter(sections) { section ->
                val subFragment = SubsectionFragment().apply {
                    arguments = Bundle().apply {
                        putString("section_title", section.title)
                        putParcelableArrayList("subtopics", ArrayList(section.subtopics))
                    }
                }
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, subFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun getSectionsForGrade(grade: Int): List<Topic> = when (grade) {
        9 -> listOf(
            Topic(
                title = "Basics of Measurement",
                subtopics = listOf(
                    Topic("Intro to Physics & SI Units", content = "Introduction to physics concepts and SI units.", youtubeUrl = "https://youtu.be/57Qs2j9gTHY?si=zHsPsNrjKcNQ67RJ"),
                    Topic("Accuracy & Precision", content = "Understanding accuracy and precision in measurements.", youtubeUrl = "https://youtu.be/hRAFPdDppzs?si=eDj7E0liMGVGH3Xj"),
                    Topic("Types of Errors", content = "Types of errors in experimental data.", youtubeUrl = "https://youtu.be/La9GfKYbhyw?si=FgrtTjI_b9V02kCd"),
                    Topic("Uncertainty", content = "Handling uncertainty in measurements.", youtubeUrl = "https://youtu.be/WjzK6UfNJDI?si=hO5rOOb86U95U_1K"),
                    Topic("Significant Figures", content = "Rules for significant figures.", youtubeUrl = "https://youtu.be/Gn97hpEkTiM?si=Zx_gJUOa0T4qk2bI"),
                    Topic("Data Tables", content = "Organizing data in tables.", youtubeUrl = "https://youtu.be/vrl1kZl7Th4?si=0sq3SUcWxHUMn3Sc"),
                    Topic("Graphs & Graphical Analysis", content = "Creating and analyzing graphs.", youtubeUrl = "https://youtu.be/wEQmmC_yqJE?si=3wbglwJDUOTOUcfk")
                )
            ),
            Topic(
                title = "Mechanics",
                subtopics = listOf(
                    Topic(
                        title = "Kinematics",
                        subtopics = listOf(
                            Topic("Scalar vs Vector", content = "Difference between scalar and vector quantities.", youtubeUrl = "https://youtu.be/rcDXQ-5H8mk?si=7TrIukWeIRGy48rj"),
                            Topic("Uniform Motion", content = "Motion with constant velocity.", youtubeUrl = "https://youtu.be/VFfF3F-G9Uk?si=YCB_MoQESn88ZzlZ"),
                            Topic("Accelerated Motion (SUVAT)", content = "Equations for accelerated motion.", youtubeUrl = "https://youtu.be/NJRsGRNCqkQ?si=8qfHBocoAaVicd2U"),
                            Topic("Free Fall", content = "Motion under gravity.", youtubeUrl = "https://youtu.be/wf8SYTb4r-g?si=G92ZAPbRv0xe1PLi", youtubeUrl2 = "https://youtu.be/BVgemK1Y2wA?si=8vZcDR9lbtJrhGty")
                        )
                    ),
                    Topic(
                        title = "Forces & Newton's Laws",
                        subtopics = listOf(
                            Topic("Types of Forces", content = "Overview of different forces.", youtubeUrl = "https://youtu.be/E626-DiQgRs?si=2xdHxPLFPy08vNU_"),
                            Topic("Free Body Diagrams", content = "Drawing force diagrams.", youtubeUrl = "https://youtu.be/52R61aSWHg0?si=JaUrirN4j0lm5yd0"),
                            Topic("Newton’s 1st Law", content = "Law of inertia.", youtubeUrl = "https://youtu.be/1XSyyjcEHo0?si=rvvQIiqSviLUWcHg"),
                            Topic("Newton’s 2nd Law (F=ma)", content = "Force and acceleration.", youtubeUrl = "https://youtu.be/xzA6IBWUEDE?si=6NEm-ZUCdqhirg7H"),
                            Topic("Newton’s 3rd Law", content = "Action and reaction.", youtubeUrl = "https://youtu.be/y61_VPKH2B4?si=oplHoeggNvMrcjfp"),
                            Topic("Friction", content = "Frictional forces.", youtubeUrl = "https://youtu.be/RIBeeW1DSZg?si=Er9Pd6Q6ZirhBPZ5"),
                            Topic("Spring Force (Hooke’s Law)", content = "Elastic forces.", youtubeUrl = "https://youtu.be/gZ_KnZHCn4M?si=95kgcGMj6EojEM22")
                        )
                    ),
                    Topic(
                        title = "Momentum & Equilibrium",
                        subtopics = listOf(
                            Topic("Momentum (p = mv) and Impulse (FΔt)", content = "Momentum and impulse concepts.", youtubeUrl = "https://youtu.be/E13h1E_Pc00?si=VnlKuuK0xnGPLu9u"),
                            Topic("Conservation of Momentum", content = "Conservation law.", youtubeUrl = "https://youtu.be/YEHcQD6Hij8?si=NhvkZMOJSdO9EoxA"),
                            Topic("Moment of Force (Torque) and Conditions for Equilibrium", content = "Torque and balance.", youtubeUrl = "https://youtu.be/p7QS4cz-Avs?si=5cvaP3it-sc308dL", youtubeUrl2 = "https://youtu.be/22VGQM1jCn8?si=WBGJiJ0EzCGkKt5h")
                        )
                    ),
                    Topic(
                        title = "Energy",
                        subtopics = listOf(
                            Topic("Kinetic Energy (KE) and Gravitational Potential Energy (GPE)", content = "Types of energy.", youtubeUrl = "https://youtu.be/DyaVgHGssos?si=bzWlhyF5BJxMVbYZ"),
                            Topic("Work Done and Work–Energy Principle", content = "Work and energy relationship.", youtubeUrl = "https://youtu.be/MR8jQZLcHKM?si=xPQQkpnnZFQEF3N7"),
                            Topic("Power", content = "Rate of energy transfer.", youtubeUrl = "https://youtu.be/EDT0DPhaaMY?si=B1xM0RR8m5UWDDwt"),
                            Topic("Efficiency", content = "Energy efficiency.", youtubeUrl = "https://youtu.be/NI5jaeBrIgQ?si=RD0HWBXeiGnh_qX8")
                        )
                    )
                )
            ),
            Topic(
                title = "Thermal Physics",
                subtopics = listOf(
                    Topic("Temperature vs Heat", content = "Difference between temperature and heat.", youtubeUrl = "https://youtu.be/LL54E5CzQ-A?si=GFLIvfGuFglHTwkx"),
                    Topic("Internal Energy", content = "Energy within a system.", youtubeUrl = "https://youtu.be/aDXQBE4r65Y?si=Gr_cCO0_9fKYcT0V"),
                    Topic("Kinetic Molecular Theory (KMT)", content = "Theory of particle motion.", youtubeUrl = "https://youtu.be/o3f_VJ87Df0?si=GEIVxprIP7mZpFA1"),
                    Topic("Boiling & Evaporation", content = "Phase changes.", youtubeUrl = "https://youtu.be/_R4Nw-UxeTk?si=r9Apk2CVY2TLE5Eh"),
                    Topic("1st Law of Thermodynamics", content = "Energy conservation.", youtubeUrl = "https://youtu.be/O7HwhkYt6YU?si=CcMtUDPd-WOtqMqO"),
                    Topic("Specific Heat Capacity (Q = mcΔT)", content = "Heat and temperature change.", youtubeUrl = "https://youtu.be/yhNHJ7WdT8A?si=E-pCL1oe66tZSBs3"),
                    Topic("Latent Heat (Fusion & Vaporization)", content = "Heat of phase transition.", youtubeUrl = "https://youtu.be/dxtz2POUTJE?si=1oeIl-qSo53hyuPq"),
                    Topic("Gas Laws (Boyle’s, Charles’s, etc.)", content = "Gas behavior laws.", youtubeUrl = "https://youtu.be/Hd7OoTLBZDA?si=7CJI6RUS8K8DaHtD")
                )
            )
        )
        10 -> listOf(
            Topic(
                title = "Electrostatics. Electric current.",
                subtopics = listOf(
                    Topic("Coulomb's Law and Electric field", content = "Electric force and field.", youtubeUrl = "https://youtu.be/MsINeZMeTMQ?si=XY9iPMsdgmz8sIR6"),
                    Topic("Electric field strength", content = "Strength of electric fields.", youtubeUrl = "https://youtu.be/VFbyDCG_j18?si=bP19hIvRL-U3DQ6m"),
                    Topic("Electric current Potential difference Resistance", content = "Basics of circuits.", youtubeUrl = "https://youtu.be/XWlZ9bfGIoI?si=ng6GV861Fm4HKzYM"),
                    Topic("Ohm’s law", content = "Voltage, current, resistance.", youtubeUrl = "https://youtu.be/_rSHqvjDksg?si=PjVFCUW6dOAjEtZ3"),
                    Topic("Series circuits and Parallel circuits", content = "Circuit configurations.", youtubeUrl = "https://youtu.be/8Z0jhQeYDUE?si=YvP7Wi_ff8f65p8X"),
                    Topic("Power and Energy", content = "Electrical power.", youtubeUrl = "https://youtu.be/1f1vQAWwjlc?si=p5W3nhgo1F0xyBAh"),
                    Topic("Cost of electrical energy", content = "Energy cost calculation.", youtubeUrl = "https://youtu.be/i1TJV-9ljDs?si=vcaZEmmT7_uh7IAL")
                )
            ),
            Topic(
                title = "Electromagnetic induction.",
                subtopics = listOf(
                    Topic("Magnets and A magnetic field", content = "Magnetic field basics.", youtubeUrl = "https://youtu.be/IgtIdttfGVw?si=9oezUsr2ciW8mbcQ"),
                    Topic("Magnetization and demagnetization", content = "Magnetic properties.", youtubeUrl = "https://youtu.be/XPjqWbvErhA?si=bqdTERwflBMsiWDv"),
                    Topic("Magnetic induction", content = "Induced magnetism.", youtubeUrl = "https://youtu.be/pQp6bmJPU_0?si=Y7TW83ljXnSs4D27"),
                    Topic("Magnetic effect of the electric current", content = "Current and magnetism.", youtubeUrl = "https://youtu.be/v7hWt9F3WcY?si=8Ilf0M541LeY-Agr"),
                    Topic("Electromagnet", content = "Electromagnetic devices.", youtubeUrl = "https://youtu.be/79_SF5AZtzo?si=93MzZBXfak7kmCyp"),
                    Topic("The magnetic force due to current", content = "Force from current.", youtubeUrl = "https://youtu.be/7MBawzone30?si=pq-_v_jAu3HrzPvb"),
                    Topic("The magnetic flux", content = "Flux concepts.", youtubeUrl = "https://youtu.be/m1PPujngqAw?si=dohSyM7kT7xCY0az"),
                    Topic("Electromagnetic induction", content = "Induction principles.", youtubeUrl = "https://youtu.be/3HyORmBip-w?si=eEtd2i_qDqCSQ07J")
                )
            ),
            Topic(
                title = "Oscillation and waves",
                subtopics = listOf(
                    Topic("Oscillations and waves", content = "Wave motion basics.", youtubeUrl = "https://youtu.be/LoRRE2aG3AY?si=_C682nbLJvhKHatK"),
                    Topic("Simple Pendulum and Mass-Spring Systems", content = "Oscillatory systems.", youtubeUrl = "https://youtu.be/4pwtiZVmN8k?si=vARH3oQauzlWm6ZC"),
                    Topic("Law of conservation of energy", content = "Energy in oscillations.", youtubeUrl = "https://youtu.be/OTK9JrKC6EY?si=4ep5vPGGpmjeWa2G"),
                    Topic("Longitudinal and transverse waves", content = "Wave types.", youtubeUrl = "https://youtu.be/1DFAy8MXkMA?si=pCtq7yQ-zgyjz-sO"),
                    Topic("Sound waves", content = "Sound properties.", youtubeUrl = "https://youtu.be/s9wZkP64rAc?si=rwdSJmlXiVP-1KSE"),
                    Topic("EM waves", content = "Electromagnetic waves.", youtubeUrl = "https://youtu.be/Je_f4RimfKI?si=ayD7jNBekXmIaNHN")
                )
            ),
            Topic(
                title = "Optics",
                subtopics = listOf(
                    Topic("Reflection and refraction of light", content = "Light behavior.", youtubeUrl = "https://youtu.be/bqWI4hxzZUs?si=gEbfxjO8B74JJzeV"),
                    Topic("Lenses. Magnification of lenses", content = "Lens properties.", youtubeUrl = "https://youtu.be/if-X8MCltso?si=co8_qEfm8II62ZQt"),
                    Topic("Converging and diverging lenses", content = "Lens types.", youtubeUrl = "https://youtu.be/OIf7Mnv92mg?si=JTk-nWsQSvCDosKm"),
                    Topic("Dispersion of light. Human eye", content = "Light dispersion.", youtubeUrl = "https://youtu.be/ASEdGwpyn58?si=PMfg4W_pcFjZCL7m")
                )
            ),
            Topic(
                title = "Atomic and nuclear physics",
                subtopics = listOf(
                    Topic("Structure of atoms. Isotopes", content = "Atomic structure.", youtubeUrl = "https://youtu.be/KwOHJbE4Tro?si=mLZMvvf28rPNtnjv"),
                    Topic("Radioactive decay. Alpha and beta decay", content = "Types of decay.", youtubeUrl = "https://youtu.be/VeXpMijpazE?si=rdexGmB-_ZikAgt5"),
                    Topic("The law of radioactive decay", content = "Decay law.", youtubeUrl = "https://youtu.be/f6NOTo3YAts?si=NJqhLhvkvakhh3iL")
                )
            )
        )
        11 -> listOf(
            Topic(title = "A. Space, time and motion", subtopics = listOf(
                Topic(title = "A1 Kinematics", subtopics = listOf(
                    Topic("A1.1 Displacement, distance, speed and velocity", youtubeUrl = "https://youtu.be/-Py2zI29THg?si=mpansUFj-tcCR97e"),
                    Topic("A1.2 Uniformly accelerated motion: the equations of kinematics", youtubeUrl = "https://youtu.be/dHjWVlfNraM?si=2-ITmLcuIaNB896b"),
                    Topic("A1.3 Graphs of motion", youtubeUrl = "https://youtu.be/nUb7xfkc0Ac?si=gCiCNjO5ifAvGHkj"),
                    Topic("A1.4 Projectile motion",
                        youtubeUrl = "https://youtu.be/ib-y7a0VPH0?si=idX4oClAECXQtmxH",
                        youtubeUrl2 = "https://youtu.be/V3L9P4o_tOk?si=wy7BX_CvkClBZqnk")
                )),
                Topic(title = "A2 Forces and Newton’s laws", subtopics = listOf(
                    Topic("A2.1 Forces and their direction",
                        youtubeUrl = "https://youtu.be/dqz0xssiVvw?si=kdaDRkZc5MpzJcs2",
                        youtubeUrl2 = "https://youtu.be/rwiSRTryZHU?si=GCfTuUN2N5x-OYl6"),
                    Topic("A2.2 Newton’s laws of motion", youtubeUrl = "https://youtu.be/g550H4e5FCY?si=VJAed4NkFWyoh-eQ"),
                    Topic("A2.3 Circular motion",
                        youtubeUrl = "https://youtu.be/_ZwjOOKQA08?si=Ggqe0xxrsWwC0FUG",
                        youtubeUrl2 = "https://youtu.be/kLN9W73ASrQ?si=gro2Xa0saagRpAMa")
                )),
                Topic(title = "A2 Linear momentum", subtopics = listOf(
                    Topic("A2.4 Newton’s second law in terms of momentum", youtubeUrl = "https://youtu.be/NIVNfI0RN2k?si=npIPjVUJ6NYQ3zvI"),
                    Topic("A2.5 Impulse and force–time graphs", youtubeUrl = "https://youtu.be/Bv9ry123zck?si=_ZQcMIAbqNxKqqRw"),
                    Topic("A2.6 Conservation of momentum",
                        youtubeUrl = "https://youtu.be/Fp7D5D8Bqjc?si=ce_w1N40BmzUEJ-f",
                        youtubeUrl2 = "https://youtu.be/U9NVCW_GjVI?si=wNWBqs1nE9XFihja"),
                    Topic("A2.7 Kinetic energy and momentum",
                        youtubeUrl = "https://youtu.be/dRO-lPus188?si=8xLga3-kIxM7VJs_",
                        youtubeUrl2 = "https://youtu.be/5LoMyEZ1XOs?si=kNl9yo7u54Sxa8Sl"),
                    Topic("A2.8 Two-dimensional collisions",
                        youtubeUrl = "https://youtu.be/9YRgHikdcqs?si=ArEyvuoM7Lp8uSDZ",
                        youtubeUrl2 = "https://youtu.be/p19i0gk3uFE?si=7Wfo3TlhtL6ERK5D")
                )),
                Topic(title = "A3 Work, energy and power", subtopics = listOf(
                    Topic("A3.1 Work", youtubeUrl = "https://youtu.be/i7tmmv84N7c?si=tdiqIxwBTIsmlHY9"),
                    Topic("A3.2 Conservation of energy", youtubeUrl = "https://youtu.be/_DwG8fukuj4?si=4wlkT86JNiATbSSn"),
                    Topic("A3.3 Power and efficiency",
                        youtubeUrl = "https://youtu.be/xmMAoNYjE3U?si=k71PO7t64ApckpK4",
                        youtubeUrl2 = "https://youtu.be/ZC8UDVFTY6k?si=2q-dbu5nsDQ-zVcr"),
                    Topic("A3.4 Energy transfers", youtubeUrl = "https://youtu.be/L0qTSInkiHg?si=jxlUHtidPRetqIQ6")
                ))
            )),

            Topic(title = "B. The particulate nature of matter", subtopics = listOf(
                Topic(title = "B1 Thermal energy transfers", subtopics = listOf(
                    Topic("B1.1 Particles, temperature and energy", youtubeUrl = "https://youtu.be/i0vRvMYP-wg?si=c1OFohYmjcGAGyhz"),
                    Topic("B1.2 Specific heat capacity and change of phase",
                        youtubeUrl = "https://youtu.be/jyVNB9KG3Ew?si=JkvSYRbfm-NUzK9A",
                        youtubeUrl2 = "https://youtu.be/dxtz2POUTJE?si=KYmMBYe-8gklnV1i"),
                    Topic("B1.3 Thermal energy transfer", youtubeUrl = "https://youtu.be/L0qTSInkiHg?si=jxlUHtidPRetqIQ6")
                )),
                Topic(title = "B2 The greenhouse effect", subtopics = listOf(
                    Topic("B2.1 Radiation from real bodies",
                        youtubeUrl = "https://youtu.be/7BXvc9W97iU?si=H6d1vwadWlOILJnb",
                        youtubeUrl2 = "https://youtu.be/eU6VqGIc-2Q?si=i1iU3aeGn7pLuHyi"),
                    Topic("B2.2 Energy balance of the earth", youtubeUrl = "https://youtu.be/GLjG0z3Q1i4?si=91c0O5VN4OP8BcUD")
                )),
                Topic(title = "B3 The gas laws", subtopics = listOf(
                    Topic("B3.1 Moles, molar mass and the Avogadro constant", youtubeUrl = "https://youtu.be/Q9AmB-fMjYg?si=HK3hxZ90GvCxQsHJ"),
                    Topic("B3.2 Ideal gases", youtubeUrl = "https://youtu.be/zA9PyKEDXY8?si=D-vpfkzqmivHJPGj"),
                    Topic("B3.3 The Boltzmann equation",
                        youtubeUrl = "https://youtu.be/lP8RwT9M8FE?si=FE6z26S3ZCwnqNpk",
                        youtubeUrl2 = "https://youtu.be/t4-Dg_ldFdw?si=dlJcTpkqJYbuZtdG")
                )),
                Topic(title = "B5 Current and circuits", subtopics = listOf(
                    Topic("B5.1 Potential difference, current and resistance", youtubeUrl = "https://youtu.be/08YugQce9OA?si=aaPvcLU_CdTODvWI"),
                    Topic("B5.2 Voltage, power and emf",
                        youtubeUrl = "https://youtu.be/i1TJV-9ljDs?si=RPmyA9YGVyQqzMcI",
                        youtubeUrl2 = "https://youtu.be/k077CwKGiwk?si=yYzrJsHHGh2GJ11k"),
                    Topic("B5.3 Resistors in electrical circuits", youtubeUrl = "https://youtu.be/dEuBykX5_B4?si=RUPH0BJ0U74bKvuG"),
                    Topic("B5.4 Terminal potential difference, internal resistance and the potential divider", youtubeUrl = "https://youtu.be/R1QN_0fcZ_8?si=i_Tfh7S5GT8In5vM")
                ))
            )),

            Topic(title = "C. Wave behaviour", subtopics = listOf(
                Topic(title = "C1 Simple harmonic motion", subtopics = listOf(
                    Topic("C1.1 Simple harmonic oscillations", youtubeUrl = "https://youtu.be/NxQQjnpL7U0?si=uJM5TVhEtUHzo5EB"),
                    Topic("C1.2 Simple pendulum and mass-spring system", youtubeUrl = "https://youtu.be/1Q15fgz-lUk?si=msUpXDPkHeLLp7od"),
                    Topic("C1.3 Details of simple harmonic motion", youtubeUrl = "https://youtu.be/wIgWv1KexOU?si=YGv9Rch6GCU38GGH"),
                    Topic("C1.4 Energy in simple harmonic motion", youtubeUrl = "https://youtu.be/I_YAWd_rn7I?si=RYjCa1_01DmLTpjA")
                )),
                Topic(title = "C2 Wave model", subtopics = listOf(
                    Topic("C2.1 Mechanical pulses and waves"), // пока без видео
                    Topic("C2.2 Transverse and longitudinal waves", youtubeUrl = "https://youtu.be/XY0RJu4sDHk?si=pOuwc8ePycsPAnUS"),
                    Topic("C2.3 Electromagnetic waves", youtubeUrl = "https://youtu.be/bxHs9I3lbZc?si=gUanH_RL_BqILszM")
                )),
                Topic(title = "C3 Wave phenomena", subtopics = listOf(
                    Topic("C3.1 Reflection and refraction",
                        youtubeUrl = "https://youtu.be/tlpbmv4bGus?si=Uc083NUI3NnLyepy",
                        youtubeUrl2 = "https://youtu.be/U-8HQZuYLD8?si=aUtFoW0up1uiDrQ2"),
                    Topic("C3.2 The principle of superposition", youtubeUrl = "https://youtu.be/0TbBy3D91WM?si=kqRdZ31NNzR5pG8s"),
                    Topic("C3.3 Diffraction and interference", youtubeUrl = "https://youtu.be/elq0PbvAwic?si=285skCyJD_ad8zKW"),
                    Topic("C3.4 Single-slit interference", youtubeUrl = "https://youtu.be/GeDiuy3nIcg?si=N3s8Gmyqjupo_o-F"),
                    Topic("C3.5 Double-slit interference", youtubeUrl = "https://youtu.be/-OWM2E8D9HI?si=jZ-_SirOUjK3y_gg"),
                    Topic("C3.6 Multiple-slits", youtubeUrl = "https://youtu.be/TgiUSCHpQDs?si=8-Ke1JpN6tWuU1vT"),
                    Topic("C3.7 Diffraction gratings",
                        youtubeUrl = "https://youtu.be/6AIL54pceP8?si=Hk5DjhgXakZ7cpg-",
                        youtubeUrl2 = "https://youtu.be/gf7j2fumz70?si=s42RfmSKv-JJXU_d")
                )),
                Topic(title = "C4 Standing waves and resonance", subtopics = listOf(
                    Topic("C4.1 Standing waves", youtubeUrl = "https://youtu.be/-HW8JcL8wms?si=O328wwAkeFse1Njn"),
                    Topic("C4.2 Standing waves on strings", youtubeUrl = "https://youtu.be/8LeFGORBEbU?si=uamsLMyfAAPe9pyK"),
                    Topic("C4.3 Standing waves in pipes", youtubeUrl = "https://youtu.be/3MwNrfEJjBU?si=d1kDwY2BMYBvRU2g"),
                    Topic("C4.4 Resonance and damping", youtubeUrl = "https://youtu.be/yoAQfbj6P9Q?si=RfgLW7sUerTTT1yq")
                )),
                Topic(title = "C5 Doppler effect", subtopics = listOf(
                    Topic("C5.1 Nature of the Doppler Effect", youtubeUrl = "https://youtu.be/VGj2Y4CiJ3U?si=U-7J_5lyM6WgCO7Q"),
                    Topic("C5.2 Doppler Effect for EM waves", youtubeUrl = "https://youtu.be/5zkDyz5LmTI?si=STZ6hdLPY_w5pJg7"),
                    Topic("C5.3 The Doppler effect for sound", youtubeUrl = "https://youtu.be/iNKrC0BjoSQ?si=pHhShucbd8xs4CkD")
                ))
            ))
        )

        12 -> listOf(
                Topic(title = "D. Fields", subtopics = listOf(
                    Topic(title = "D1 Gravitational fields", subtopics = listOf(
                        Topic("D1.1 Newton’s law of gravitation", youtubeUrl = "https://youtu.be/nYnRXRUKj5o?si=_ghMhHrK0AgAGCOK"),
                        Topic("D1.2 Gravitational potential and energy", youtubeUrl = "https://youtu.be/RECwtvPu4x0?si=o_PY6W6jHB3rO1B-"),
                        Topic("D1.3 Motion in a gravitational field", youtubeUrl = "https://youtu.be/18KcT_GKSEA?si=jW_NY-LlAoKCQeiH")
                    )),
                    Topic(title = "D2 Electric and magnetic fields", subtopics = listOf(
                        Topic("D2.1 Electric charge, force and field", youtubeUrl = "https://youtu.be/qAswBNJ-NBc?si=KgehW9jba9Q3HbbW"),
                        Topic("D2.2 Electric potential and electric potential energy",
                            youtubeUrl = "https://youtu.be/LzKMQByFSLc?si=mT0ishlS_O2EWZuW",
                            youtubeUrl2 = "https://youtu.be/KoZ61FujkRk?si=4vqFJ6eajxkAdT90"),
                        Topic("D2.3 Magnetic field and force", youtubeUrl = "https://youtu.be/-DgxkmD0jD0?si=4UtaCwzdizWLv6r4")
                    )),
                    Topic(title = "D3 Motion in electric and magnetic fields", subtopics = listOf(
                        Topic("D3.1 Motion in an electric field", youtubeUrl = "https://youtu.be/KO0nOxzIn54?si=PdK9a9DBiKtXbd2r"),
                        Topic("D3.2 Motion in a magnetic field", youtubeUrl = "https://youtu.be/VkCzWS9Rtp4?si=2ZNcHYjzDZwL9IgT")
                    )),
                    Topic(title = "D4 Electromagnetic induction (HL)", subtopics = listOf(
                        Topic("D4.1 Electromagnetic induction", youtubeUrl = "https://youtu.be/xSeTVQCjno4?si=6_GCmkqVi2DKW1N-A"),
                        Topic("D4.2 Generators and alternating current",
                            youtubeUrl = "https://youtu.be/ETCLlP0hzpc?si=nfJh6yax1TZpQc6y",
                            youtubeUrl2 = "https://youtu.be/0A6YBfYLZmI?si=P5vGgXDyrW-f3s0M")
                    ))
                )),

                Topic(title = "E. Nuclear and quantum physics", subtopics = listOf(
                    Topic(title = "E1 Atomic physics", subtopics = listOf(
                        Topic("E1.1 The structure of the atom", youtubeUrl = "https://youtu.be/Nu7gJC3dQ8w?si=SA4GBPTJNrHk3YtF"),
                        Topic("E1.2 Quantization of angular momentum", youtubeUrl = "https://youtu.be/QHYJ4VpqAvs?si=elOK4wburcZ2Mn77")
                    )),
                    Topic(title = "E2 Quantum physics (HL)", subtopics = listOf(
                        Topic("E2.1 Photons and the photoelectric effect", youtubeUrl = "https://youtu.be/tmRpsk4Npr8?si=P6rMLLzAZfy7Bsv0"),
                        Topic("E2.2 Matter waves", youtubeUrl = "https://youtu.be/DDnhOLAuEb4?si=xkz7k7Fqyn-AqhrM"),
                        Topic("E2.3 Compton Effect", youtubeUrl = "https://youtu.be/hzwykQ7KSRE?si=MJBXCY4etVckrngB")
                    )),
                    Topic(title = "E3 Nuclear physics", subtopics = listOf(
                        Topic("E3.1 Mass defect and binding energy", youtubeUrl = "https://youtu.be/tflg56lLBIU?si=RZfNOJQQwe06rVVe"),
                        Topic("E3.2 Radioactivity", youtubeUrl = "https://youtu.be/P_SD5Rt6XMk?si=kncY-_NO8oXFjr5I"),
                        Topic("E3.3 Nuclear properties and the radioactive decay law", youtubeUrl = "https://youtu.be/fOMvJj39eTU?si=Tjeg-peUyFXBDQDu")
                    )),
                    Topic(title = "E4 Fission", subtopics = listOf(
                        Topic("E4.1 Nuclear fission", youtubeUrl = "https://youtu.be/FWjxfDMIZcY?si=sKZIxsSSV2B-ekDB")
                    )),
                    Topic(title = "E5 Fusion and stars", subtopics = listOf(
                        Topic("E5.1 Nuclear fusion", youtubeUrl = "https://youtu.be/5jDYvbvqCBs?si=TLiyscigptkYWc47"),
                        Topic("E5.2 Stellar properties and the Hertzsprung–Russell diagram",
                            youtubeUrl = "https://youtu.be/uukVtisyfXY?si=jeCY2ScpxYKxkuLC",
                            youtubeUrl2 = "https://youtu.be/I6E0jNYEe9Q?si=mIsiF8sjTOlhjp9k"),
                        Topic("E5.3 Stellar evolution",
                            youtubeUrl = "https://youtu.be/222JprAo7K8?si=hYuJwVJ_6oGkqTFJ",
                            youtubeUrl2 = "https://youtu.be/IZTOWJXAo0E?si=qYWPAujfcxVBr9Hm")
                    ))
                )),

                Topic(title = "A4 Rigid body mechanics (HL)", subtopics = listOf(
                    Topic("A4.1 Kinematics of rotational motion",
                        youtubeUrl = "https://youtu.be/DQ0fBtwCoqs?si=qAQuiBJzqSsUG1EQ",
                        youtubeUrl2 = "https://youtu.be/0El-DqrCTZM?si=Wu0CiU1I2lLDsTsR"),
                    Topic("A4.2 Rotational equilibrium and Newton’s second law",
                        youtubeUrl = "https://youtu.be/OXUQ9TSToqs?si=TA_-IDN6TqDSogS3",
                        youtubeUrl2 = "https://youtu.be/xusMSv2z77s?si=gvQepotntGP9hPyQ"),
                    Topic("A4.3 Angular momentum",
                        youtubeUrl = "https://youtu.be/dyUWjOMuhGA?si=IcK-aXHaaBxtPz_c",
                        youtubeUrl2 = "https://youtu.be/QghXDDJtJeQ?si=7R-RgNJ45H-SMYo2")
                )),

                Topic(title = "A5 Galilean and special relativity (HL)", subtopics = listOf(
                    Topic("A5.1 Reference frames and Lorentz transformations",
                        youtubeUrl = "https://youtu.be/pdX74x3xiMk?si=DuhlWvvEqT0j5VJ7",
                        youtubeUrl2 = "https://youtu.be/ckfUwCwMFNU?si=W83UWQe3ikkhfxbw"),
                    Topic("A5.2 Effects of relativity", youtubeUrl = "https://youtube.com/playlist?list=PL6LH0ngwf3HvWAs3jOeL0JMdtjAS8Ujzl&si=ZUUcOzczwZZjHBAI"),
                    Topic("A5.3 Space-time diagrams", youtubeUrl = "https://youtu.be/dAr5CszwK60?si=HWKDBdRZ0vChXcL_")
                )),

                Topic(title = "B4 Thermodynamics (HL)", subtopics = listOf(
                    Topic("B4.1 Internal energy", youtubeUrl = "https://youtu.be/YakHuVJuwhc?si=HC2mZHFN8Bl6NeWp"),
                    Topic("B4.2 The first law of thermodynamics", youtubeUrl = "https://youtu.be/6gr7SxJDZwQ?si=Z3_6tpyNgCuey3M3"),
                    Topic("B4.3 The second law of thermodynamics and entropy", youtubeUrl = "https://youtu.be/_RQIVTeIPVc?si=_cEa45_z6WYVvEIT"),
                    Topic("B4.4 Heat engines",
                        youtubeUrl = "https://youtu.be/RkyijphBOSU?si=b-OpRneqWkA-FZVJ",
                        youtubeUrl2 = "https://youtu.be/O7TSo_up1Dw?si=8ZkRYpzcfWYx97XE")
                ))
            )
        else -> emptyList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}