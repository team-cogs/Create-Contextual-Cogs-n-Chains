package mod.teamcogs.c_cubic.register

import com.jozufozu.flywheel.core.PartialModel
import com.simibubi.create.Create
import mod.TeamCogs.c_cubic.BuildConfig
import net.minecraft.resources.ResourceLocation

object ModPartials {
    operator fun get(name: String): PartialModel {
        return PartialModel(ResourceLocation(BuildConfig.MODID, "block/$name"))
    }

    fun getCreate(name: String): PartialModel {
        return PartialModel(Create.asResource("block/$name"))
    }

    fun getEntity(name: String): PartialModel {
        return PartialModel(ResourceLocation(BuildConfig.MODID, "entity/$name"))
    }

    fun getEntityCreate(name: String): PartialModel {
        return PartialModel(Create.asResource("entity/$name"))
    }

    fun load() {}
}
