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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
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
                        putBoolean("isFormulas", false)
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
                    title = "Unit 1. Basics of Measurement",
                    subtopics = listOf(
                        Topic("Intro to Physics & SI Units", content = "...", youtubeUrl = "https://youtu.be/57Qs2j9gTHY"),
                        Topic("Accuracy & Precision", content = "...", youtubeUrl = "https://youtu.be/hRAFPdDppzs"),
                        Topic("Types of Errors", content = "...", youtubeUrl = "https://youtu.be/La9GfKYbhyw"),
                        Topic("Uncertainty", content = "...", youtubeUrl = "https://youtu.be/WjzK6UfNJDI"),
                        Topic("Significant Figures", content = "...", youtubeUrl = "https://youtu.be/Gn97hpEkTiM"),
                        Topic("Data Tables", content = "...", youtubeUrl = "https://youtu.be/vrl1kZl7Th4"),
                        Topic("Graphs & Graphical Analysis", content = "...", youtubeUrl = "https://youtu.be/wEQmmC_yqJE")
                    )
                ),
                Topic(
                    title = "Unit 2. Mechanics",
                    subtopics = listOf(
                        Topic(
                            title = "Kinematics",
                            subtopics = listOf(
                                Topic("Scalar vs Vector", content = "...", youtubeUrl = "https://youtu.be/rcDXQ-5H8mk"),
                                Topic("Uniform Motion", content = "...", youtubeUrl = "https://youtu.be/VFfF3F-G9Uk"),
                                Topic("Accelerated Motion (SUVAT)", content = "...", youtubeUrl = "https://youtu.be/NJRsGRNCqkQ"),
                                Topic("Free Fall", content = "...", youtubeUrl = "https://youtu.be/wf8SYTb4r-g", youtubeUrl2 = "https://youtu.be/BVgemK1Y2wA")
                            )
                        ),
                        Topic(
                            title = "Forces & Newton's Laws",
                            subtopics = listOf(
                                Topic("Types of Forces", content = "...", youtubeUrl = "https://youtu.be/E626-DiQgRs"),
                                Topic("Free Body Diagrams", content = "...", youtubeUrl = "https://youtu.be/52R61aSWHg0"),
                                Topic("Newton’s 1st Law", content = "...", youtubeUrl = "https://youtu.be/1XSyyjcEHo0"),
                                Topic("Newton’s 2nd Law (F=ma)", content = "...", youtubeUrl = "https://youtu.be/xzA6IBWUEDE"),
                                Topic("Newton’s 3rd Law", content = "...", youtubeUrl = "https://youtu.be/y61_VPKH2B4"),
                                Topic("Friction", content = "...", youtubeUrl = "https://youtu.be/RIBeeW1DSZg"),
                                Topic("Spring Force (Hooke’s Law)", content = "...", youtubeUrl = "https://youtu.be/gZ_KnZHCn4M")
                            )
                        ),
                        Topic(
                            title = "Momentum & Equilibrium",
                            subtopics = listOf(
                                Topic("Momentum (p = mv) and Impulse (FΔt)", content = "...", youtubeUrl = "https://youtu.be/E13h1E_Pc00"),
                                Topic("Conservation of Momentum", content = "...", youtubeUrl = "https://youtu.be/YEHcQD6Hij8"),
                                Topic("Moment of Force (Torque) and Conditions for Equilibrium", content = "...", youtubeUrl = "https://youtu.be/p7QS4cz-Avs", youtubeUrl2 = "https://youtu.be/22VGQM1jCn8")
                            )
                        ),
                        Topic(
                            title = "Energy",
                            subtopics = listOf(
                                Topic("Kinetic Energy (KE) and Gravitational Potential Energy (GPE)", content = "...", youtubeUrl = "https://youtu.be/DyaVgHGssos"),
                                Topic("Work Done and Work–Energy Principle", content = "...", youtubeUrl = "https://youtu.be/MR8jQZLcHKM"),
                                Topic("Power", content = "...", youtubeUrl = "https://youtu.be/EDT0DPhaaMY"),
                                Topic("Efficiency", content = "...", youtubeUrl = "https://youtu.be/NI5jaeBrIgQ")
                            )
                        )
                    )
                ),
                Topic(
                    title = "Unit 3. Thermal Physics",
                    subtopics = listOf(
                        Topic("Temperature vs Heat", content = "...", youtubeUrl = "https://youtu.be/LL54E5CzQ-A"),
                        Topic("Internal Energy", content = "...", youtubeUrl = "https://youtu.be/aDXQBE4r65Y"),
                        Topic("Kinetic Molecular Theory (KMT)", content = "...", youtubeUrl = "https://youtu.be/o3f_VJ87Df0"),
                        Topic("Boiling & Evaporation", content = "...", youtubeUrl = "https://youtu.be/_R4Nw-UxeTk"),
                        Topic("1st Law of Thermodynamics", content = "...", youtubeUrl = "https://youtu.be/O7HwhkYt6YU"),
                        Topic("Specific Heat Capacity (Q = mcΔT)", content = "...", youtubeUrl = "https://youtu.be/yhNHJ7WdT8A"),
                        Topic("Latent Heat (Fusion & Vaporization)", content = "...", youtubeUrl = "https://youtu.be/dxtz2POUTJE"),
                        Topic("Gas Laws (Boyle’s, Charles’s, etc.)", content = "...", youtubeUrl = "https://youtu.be/Hd7OoTLBZDA")
                    )
                )
            )
        10 -> listOf(
            Topic(
                title = "Unit 1. Electrostatics. Electric current.",
                subtopics = listOf(
                    Topic("Coulomb's Law and Electric field", content = "...", youtubeUrl = "https://youtu.be/MsINeZMeTMQ"),
                    Topic("Electric field strength", content = "...", youtubeUrl = "https://youtu.be/VFbyDCG_j18"),
                    Topic("Electric current Potential difference Resistance", content = "...", youtubeUrl = "https://youtu.be/XWlZ9bfGIoI"),
                    Topic("Ohm’s law", content = "...", youtubeUrl = "https://youtu.be/_rSHqvjDksg"),
                    Topic("Series circuits and Parallel circuits", content = "...", youtubeUrl = "https://youtu.be/8Z0jhQeYDUE"),
                    Topic("Power and Energy", content = "...", youtubeUrl = "https://youtu.be/1f1vQAWwjlc"),
                    Topic("Cost of electrical energy", content = "...", youtubeUrl = "https://youtu.be/i1TJV-9ljDs")
                )
            ),
            Topic(
                title = "Unit 2. Electromagnetic induction.",
                subtopics = listOf(
                    Topic("Magnets and A magnetic field", content = "...", youtubeUrl = "https://youtu.be/IgtIdttfGVw"),
                    Topic("Magnetization and demagnetization", content = "...", youtubeUrl = "https://youtu.be/XPjqWbvErhA"),
                    Topic("Magnetic induction", content = "...", youtubeUrl = "https://youtu.be/pQp6bmJPU_0"),
                    Topic("Magnetic effect of the electric current", content = "...", youtubeUrl = "https://youtu.be/v7hWt9F3WcY"),
                    Topic("Electromagnet", content = "...", youtubeUrl = "https://youtu.be/79_SF5AZtzo"),
                    Topic("The magnetic force due to current", content = "...", youtubeUrl = "https://youtu.be/7MBawzone30"),
                    Topic("The magnetic flux", content = "...", youtubeUrl = "https://youtu.be/m1PPujngqAw"),
                    Topic("Electromagnetic induction", content = "...", youtubeUrl = "https://youtu.be/3HyORmBip-w")
                )
            ),
            Topic(
                title = "Unit 3. Oscillation and waves",
                subtopics = listOf(
                    Topic("Oscillations and waves", content = "...", youtubeUrl = "https://youtu.be/LoRRE2aG3AY"),
                    Topic("Simple Pendulum and Mass-Spring Systems", content = "...", youtubeUrl = "https://youtu.be/4pwtiZVmN8k"),
                    Topic("Law of conservation of energy", content = "...", youtubeUrl = "https://youtu.be/OTK9JrKC6EY"),
                    Topic("Longitudinal and transverse waves", content = "...", youtubeUrl = "https://youtu.be/1DFAy8MXkMA"),
                    Topic("Sound waves", content = "...", youtubeUrl = "https://youtuVadP64rAc"),
                    Topic("EM waves", content = "...", youtubeUrl = "https://youtu.be/Je_f4RimfKI")
                )
            ),
            Topic(
                title = "Unit 4. Optics",
                subtopics = listOf(
                    Topic("Reflection and refraction of light", content = "...", youtubeUrl = "https://youtu.be/bqWI4hxzZUs"),
                    Topic("Lenses. Magnification of lenses", content = "...", youtubeUrl = "https://youtu.be/if-X8MCltso"),
                    Topic("Converging and diverging lenses", content = "...", youtubeUrl = "https://youtu.be/OIf7Mnv92mg"),
                    Topic("Dispersion of light. Human eye", content = "...", youtubeUrl = "https://youtu.be/ASEdGwpyn58")
                )
            ),
            Topic(
                title = "Unit 5. Atomic and nuclear physics",
                subtopics = listOf(
                    Topic("Structure of atoms. Isotopes", content = "...", youtubeUrl = "https://youtu.be/KwOHJbE4Tro"),
                    Topic("Radioactive decay. Alpha and beta decay", content = "...", youtubeUrl = "https://youtu.be/VeXpMijpazE"),
                    Topic("The law of radioactive decay", content = "...", youtubeUrl = "https://youtu.be/f6NOTo3YAts")
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