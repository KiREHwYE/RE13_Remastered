package com.kire.home.domain.repository

import com.kire.home.domain.model.TrackDomain
import kotlinx.coroutines.flow.Flow

/**
 * Repository for managing track-related data.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
interface ITrackRepository {

    /**
     * Inserts or updates a track entity in the database.
     * If the track already exists, it will be updated; otherwise, it will be inserted.
     *
     * @param track The [TrackDomain] to upsert.
     */
    suspend fun upsertTrack(track: TrackDomain)

    /**
     * Deletes a track entity from the database.
     *
     * @param track The [TrackDomain] to delete.
     */
    suspend fun deleteTrack(track: TrackDomain)

    /**
     * Retrieves all track entities from the database as a [Flow].
     *
     * @return A list of all [TrackDomain] objects in the database.
     */
     fun getAllTracks(): Flow<List<TrackDomain>>
}