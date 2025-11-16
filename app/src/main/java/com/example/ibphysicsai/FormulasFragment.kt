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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
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
                    Topic("Intro to Physics & SI Units"),
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
                    Topic("Kinematics"),
                    Topic("Forces & Newton's Laws"),
                    Topic("Momentum & Equilibrium"),
                    Topic("Energy")
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
                    Topic("Specific Heat Capacity"),
                    Topic("Latent Heat"),
                    Topic("Gas Laws")
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
        else -> emptyList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}