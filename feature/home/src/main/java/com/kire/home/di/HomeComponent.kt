package com.kire.home.di

import android.content.Context
import com.kire.database.di.DatabaseComponent
import com.kire.database.di.DatabaseModule
import com.kire.di.CoroutineModule
import com.kire.home.domain.repository.ITrackRepository
import com.kire.home.domain.usecase.ITrackUseCases
import com.kire.home.presentation.viewmodel.HomeViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component providing dependencies for the home feature's track management functionality.
 * This singleton component integrates [HomeModule] and [CoroutineModule] for module-provided dependencies
 * and depends on [DatabaseComponent] for database-related dependencies, offering access to [ITrackRepository],
 * [ITrackUseCases] and [HomeViewModelFactory] implementations. It ensures a single instance of provided objects throughout the
 * application lifecycle, facilitating track-related operations in the home feature.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Singleton
@Component(modules = [HomeModule::class, CoroutineModule::class, DatabaseModule::class])
interface HomeComponent {

    /**
     * Provides an [ITrackRepository] instance for track data management.
     *
     * @return The [ITrackRepository] implementation, typically a [TrackRepository].
     */
    fun provideTrackRepository(): ITrackRepository

    /**
     * Provides an [ITrackUseCases] instance for track-related use cases.
     *
     * @return The [ITrackUseCases] implementation, typically a [TrackUseCases].
     */
    fun provideTrackUseCases(): ITrackUseCases

    /**
     * Provides a [HomeViewModelFactory] for creating HomeViewModel instances.
     *
     * @return The [HomeViewModelFactory] instance.
     */
    fun provideHomeViewModelFactory(): HomeViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder
        fun build(): HomeComponent
    }
}