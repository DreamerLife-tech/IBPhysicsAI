package com.example.ibphysicsai

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ibphysicsai.databinding.FragmentTheoryBinding
import com.example.ibphysicsai.data.model.Topic

class FormulasFragment : Fragment() {
    private var _binding: FragmentTheoryBinding? = null
    private val binding get() = _binding!!
    private val TAG = "FormulasFragment"

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
        binding.tvGradeTitle.text = "Grade $grade – Physics Formulas"
        val sections = getFormulasForGrade(grade)
        Log.d(TAG, "Sections for Grade $grade: $sections")
        binding.rvTopics.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = SectionAdapter(sections) { section ->
                Log.d(TAG, "Selected section: ${section.title}, subtopics: ${section.subtopics}")
                val subFragment = SubsectionFragment().apply {
                    arguments = Bundle().apply {
                        putString("section_title", section.title)
                        putParcelableArrayList("subtopics", ArrayList(section.subtopics))
                        putBoolean("isFormulas", true) // Явно устанавливаем флаг
                    }
                }
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, subFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun getFormulasForGrade(grade: Int): List<Topic> = when (grade) {
        9 -> listOf(
            Topic(
                title = "Unit 1. Basics of Measurement",
                subtopics = listOf(
                    Topic("Intro to Physics & SI Units", content = "Physics explores the fundamental principles governing the universe using the International System of Units (SI). SI units ensure consistency in scientific calculations.\n" +
                            "                        - Base SI Units:\n" +
                            "                          - Length: metres (m)\n" +
                            "                          - Mass: kilograms (kg)\n" +
                            "                          - Time: seconds (s)\n" +
                            "                          - Electric current: amperes (A)\n" +
                            "                          - Temperature: kelvins (K)\n" +
                            "                          - Amount of substance: moles (mol)\n" +
                            "                          - Luminous intensity: candelas (cd)\n" +
                            "                        - Derived SI Units:\n" +
                            "                          - Area: square metres (m²)\n" +
                            "                          - Volume: cubic metres (m³)\n" +
                            "                          - Velocity: metres per second (m/s)\n" +
                            "                          - Acceleration: metres per second squared (m/s²)\n" +
                            "                          - Force: newtons (N), equivalent to kg·m/s²\n" +
                            "                          - Pressure: pascals (Pa), equivalent to kg/(m·s²)\n" +
                            "                          - Energy or work: joules (J), equivalent to kg·m²/s²\n" +
                            "                          - Power: watts (W), equivalent to kg·m²/s³\n" +
                            "                          - Charge: coulombs (C), equivalent to A·s\n" +
                            "                          - Potential difference: volts (V), equivalent to kg·m²/(A·s³)\n" +
                            "                          - Resistance: ohms (Ω), equivalent to kg·m²/(A²·s³)\n" +
                            "                          - Frequency: hertz (Hz), equivalent to 1/s\n" +
                            "                        - Prefixes:\n" +
                            "                          - Giga (G): 10⁹ (e.g., 1 GW = 10⁹ W)\n" +
                            "                          - Mega (M): 10⁶ (e.g., 1 MW = 10⁶ W)\n" +
                            "                          - Kilo (k): 10³ (e.g., 1 km = 10³ m)\n" +
                            "                          - Centi (c): 10⁻² (e.g., 1 cm = 10⁻² m)\n" +
                            "                          - Milli (m): 10⁻³ (e.g., 1 mm = 10⁻³ m)\n" +
                            "                          - Micro (μ): 10⁻⁶ (e.g., 1 μs = 10⁻⁶ s)\n" +
                            "                          - Nano (n): 10⁻⁹ (e.g., 1 ns = 10⁻⁹ s)\n" +
                            "                    \"\"\".trimIndent()\n" +
                            "                )"),
                    Topic("Accuracy & Precision"),
                    Topic("Types of Errors"),
                    Topic("Uncertainty"),
                    Topic("Significant Figures"),
                    Topic("Data Tables"),
                    Topic("Graphs & Graphical Analysis")
                )
            ),
            Topic(
                title = "Unit 2. Mechanics",
                subtopics = listOf(
                    Topic(
                        title = "Kinematics",
                        subtopics = listOf(
                            Topic("Scalar vs Vector"),
                            Topic("Uniform Motion"),
                            Topic("Accelerated Motion (SUVAT)"),
                            Topic("Free Fall")
                        )
                    ),
                    Topic(
                        title = "Forces & Newton's Laws",
                        subtopics = listOf(
                            Topic("Types of Forces"),
                            Topic("Free Body Diagrams"),
                            Topic("Newton’s 1st Law"),
                            Topic("Newton’s 2nd Law (F=ma)"),
                            Topic("Newton’s 3rd Law"),
                            Topic("Friction"),
                            Topic("Spring Force (Hooke’s Law)")
                        )
                    ),
                    Topic(
                        title = "Momentum & Equilibrium",
                        subtopics = listOf(
                            Topic("Momentum (p = mv) and Impulse (FΔt)"),
                            Topic("Conservation of Momentum"),
                            Topic("Moment of Force (Torque) and Conditions for Equilibrium")
                        )
                    ),
                    Topic(
                        title = "Energy",
                        subtopics = listOf(
                            Topic("Kinetic Energy (KE) and Gravitational Potential Energy (GPE)"),
                            Topic("Work Done and Work–Energy Principle"),
                            Topic("Power"),
                            Topic("Efficiency")
                        )
                    )
                )
            ),
            Topic(
                title = "Unit 3. Thermal Physics",
                subtopics = listOf(
                    Topic("Temperature vs Heat"),
                    Topic("Internal Energy"),
                    Topic("Kinetic Molecular Theory (KMT)"),
                    Topic("Boiling & Evaporation"),
                    Topic("1st Law of Thermodynamics"),
                    Topic("Specific Heat Capacity (Q = mcΔT)"),
                    Topic("Latent Heat (Fusion & Vaporization)"),
                    Topic("Gas Laws (Boyle’s, Charles’s, etc.)")
                )
            )
        )
        10 -> listOf(
            Topic(
                title = "Unit 1. Electrostatics. Electric Current",
                subtopics = listOf(
                    Topic("Coulomb's Law and Electric Field"),
                    Topic("Electric Field Strength"),
                    Topic("Electric Current, Potential Difference, Resistance"),
                    Topic("Ohm’s Law"),
                    Topic("Series Circuits and Parallel Circuits"),
                    Topic("Power and Energy"),
                    Topic("Cost of Electrical Energy")
                )
            ),
            Topic(
                title = "Unit 2. Electromagnetic Induction",
                subtopics = listOf(
                    Topic("Magnets and A Magnetic Field"),
                    Topic("Magnetization and Demagnetization"),
                    Topic("Magnetic Induction"),
                    Topic("Magnetic Effect of the Electric Current"),
                    Topic("Electromagnet"),
                    Topic("The Magnetic Force Due to Current"),
                    Topic("The Magnetic Flux"),
                    Topic("Electromagnetic Induction")
                )
            ),
            Topic(
                title = "Unit 3. Oscillation and Waves",
                subtopics = listOf(
                    Topic("Oscillations and Waves"),
                    Topic("Simple Pendulum and Mass-Spring Systems"),
                    Topic("Law of Conservation of Energy"),
                    Topic("Longitudinal and Transverse Waves"),
                    Topic("Sound Waves"),
                    Topic("EM Waves")
                )
            ),
            Topic(
                title = "Unit 4. Optics",
                subtopics = listOf(
                    Topic("Reflection and Refraction of Light"),
                    Topic("Lenses. Magnification of Lenses"),
                    Topic("Converging and Diverging Lenses"),
                    Topic("Dispersion of Light. Human Eye")
                )
            ),
            Topic(
                title = "Unit 5. Atomic and Nuclear Physics",
                subtopics = listOf(
                    Topic("Structure of Atoms. Isotopes"),
                    Topic("Radioactive Decay. Alpha and Beta Decay"),
                    Topic("The Law of Radioactive Decay")
                )
            )
        )
        11 -> listOf(
            Topic(title = "A. Space, time and motion", subtopics = listOf(
                Topic(title = "A1 Kinematics", subtopics = listOf(
                    Topic("A1.1 Displacement, distance, speed and velocity"),
                    Topic("A1.2 Uniformly accelerated motion: the equations of kinematics"),
                    Topic("A1.3 Graphs of motion"),
                    Topic("A1.4 Projectile motion")
                )),
                Topic(title = "A2 Forces and Newton’s laws", subtopics = listOf(
                    Topic("A2.1 Forces and their direction"),
                    Topic("A2.2 Newton’s laws of motion"),
                    Topic("A2.3 Circular motion")
                )),
                Topic(title = "A2 Linear momentum", subtopics = listOf(
                    Topic("A2.4 Newton’s second law in terms of momentum"),
                    Topic("A2.5 Impulse and force–time graphs"),
                    Topic("A2.6 Conservation of momentum"),
                    Topic("A2.7 Kinetic energy and momentum"),
                    Topic("A2.8 Two-dimensional collisions")
                )),
                Topic(title = "A3 Work, energy and power", subtopics = listOf(
                    Topic("A3.1 Work"),
                    Topic("A3.2 Conservation of energy"),
                    Topic("A3.3 Power and efficiency"),
                    Topic("A3.4 Energy transfers")
                ))
            )),

            Topic(title = "B. The particulate nature of matter", subtopics = listOf(
                Topic(title = "B1 Thermal energy transfers", subtopics = listOf(
                    Topic("B1.1 Particles, temperature and energy"),
                    Topic("B1.2 Specific heat capacity and change of phase"),
                    Topic("B1.3 Thermal energy transfer")
                )),
                Topic(title = "B2 The greenhouse effect", subtopics = listOf(
                    Topic("B2.1 Radiation from real bodies"),
                    Topic("B2.2 Energy balance of the earth")
                )),
                Topic(title = "B3 The gas laws", subtopics = listOf(
                    Topic("B3.1 Moles, molar mass and the Avogadro constant"),
                    Topic("B3.2 Ideal gases"),
                    Topic("B3.3 The Boltzmann equation")
                )),
                Topic(title = "B5 Current and circuits", subtopics = listOf(
                    Topic("B5.1 Potential difference, current and resistance"),
                    Topic("B5.2 Voltage, power and emf"),
                    Topic("B5.3 Resistors in electrical circuits"),
                    Topic("B5.4 Terminal potential difference, internal resistance and the potential divider")
                ))
            )),

            Topic(title = "C. Wave behaviour", subtopics = listOf(
                Topic(title = "C1 Simple harmonic motion", subtopics = listOf(
                    Topic("C1.1 Simple harmonic oscillations"),
                    Topic("C1.2 Simple pendulum and mass-spring system"),
                    Topic("C1.3 Details of simple harmonic motion"),
                    Topic("C1.4 Energy in simple harmonic motion")
                )),
                Topic(title = "C2 Wave model", subtopics = listOf(
                    Topic("C2.1 Mechanical pulses and waves"),
                    Topic("C2.2 Transverse and longitudinal waves"),
                    Topic("C2.3 Electromagnetic waves")
                )),
                Topic(title = "C3 Wave phenomena", subtopics = listOf(
                    Topic("C3.1 Reflection and refraction"),
                    Topic("C3.2 The principle of superposition"),
                    Topic("C3.3 Diffraction and interference"),
                    Topic("C3.4 Single-slit interference"),
                    Topic("C3.5 Double-slit interference"),
                    Topic("C3.6 Multiple-slits"),
                    Topic("C3.7 Diffraction gratings")
                )),
                Topic(title = "C4 Standing waves and resonance", subtopics = listOf(
                    Topic("C4.1 Standing waves"),
                    Topic("C4.2 Standing waves on strings"),
                    Topic("C4.3 Standing waves in pipes"),
                    Topic("C4.4 Resonance and damping")
                )),
                Topic(title = "C5 Doppler effect", subtopics = listOf(
                    Topic("C5.1 Nature of the Doppler Effect"),
                    Topic("C5.2 Doppler Effect for EM waves"),
                    Topic("C5.3 The Doppler effect for sound")
                ))
            ))
        )

        // ====================== GRADE 12 — IB DP Physics Year 2 ======================
        12 -> listOf(
            Topic(title = "D. Fields", subtopics = listOf(
                Topic(title = "D1 Gravitational fields", subtopics = listOf(
                    Topic("D1.1 Newton’s law of gravitation"),
                    Topic("D1.2 Gravitational potential and energy"),
                    Topic("D1.3 Motion in a gravitational field")
                )),
                Topic(title = "D2 Electric and magnetic fields", subtopics = listOf(
                    Topic("D2.1 Electric charge, force and field"),
                    Topic("D2.2 Electric potential and electric potential energy"),
                    Topic("D2.3 Magnetic field and force")
                )),
                Topic(title = "D3 Motion in electric and magnetic fields", subtopics = listOf(
                    Topic("D3.1 Motion in an electric field"),
                    Topic("D3.2 Motion in a magnetic field")
                )),
                Topic(title = "D4 Electromagnetic induction (HL)", subtopics = listOf(
                    Topic("D4.1 Electromagnetic induction"),
                    Topic("D4.2 Generators and alternating current")
                ))
            )),

            Topic(title = "E. Nuclear and quantum physics", subtopics = listOf(
                Topic(title = "E1 Atomic physics", subtopics = listOf(
                    Topic("E1.1 The structure of the atom"),
                    Topic("E1.2 Quantization of angular momentum")
                )),
                Topic(title = "E2 Quantum physics (HL)", subtopics = listOf(
                    Topic("E2.1 Photons and the photoelectric effect"),
                    Topic("E2.2 Matter waves"),
                    Topic("E2.3 Compton Effect")
                )),
                Topic(title = "E3 Nuclear physics", subtopics = listOf(
                    Topic("E3.1 Mass defect and binding energy"),
                    Topic("E3.2 Radioactivity"),
                    Topic("E3.3 Nuclear properties and the radioactive decay law")
                )),
                Topic(title = "E4 Fission", subtopics = listOf(
                    Topic("E4.1 Nuclear fission")
                )),
                Topic(title = "E5 Fusion and stars", subtopics = listOf(
                    Topic("E5.1 Nuclear fusion"),
                    Topic("E5.2 Stellar properties and the Hertzsprung–Russell diagram"),
                    Topic("E5.3 Stellar evolution")
                ))
            )),


            Topic(title = "A4 Rigid body mechanics (HL)", subtopics = listOf(
                Topic("A4.1 Kinematics of rotational motion"),
                Topic("A4.2 Rotational equilibrium and Newton’s second law"),
                Topic("A4.3 Angular momentum")
            )),
            Topic(title = "A5 Galilean and special relativity (HL)", subtopics = listOf(
                Topic("A5.1 Reference frames and Lorentz transformations"),
                Topic("A5.2 Effects of relativity"),
                Topic("A5.3 Space-time diagrams")
            )),
            Topic(title = "B4 Thermodynamics (HL)", subtopics = listOf(
                Topic("B4.1 Internal energy"),
                Topic("B4.2 The first law of thermodynamics"),
                Topic("B4.3 The second law of thermodynamics and entropy"),
                Topic("B4.4 Heat engines")
            )
            )
        )
        else -> emptyList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}